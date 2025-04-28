package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.*;
import com.skillbox.sb_practice.exceptions.EntityNotFoundException;
import com.skillbox.sb_practice.mapper.NewsMapper;
import com.skillbox.sb_practice.repository.CategoryRepository;
import com.skillbox.sb_practice.repository.NewsRepository;
import com.skillbox.sb_practice.repository.UserRepository;
import com.skillbox.sb_practice.utils.UserUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService{
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<NewsResponseItem> getAllNewsByPage(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        var response = newsRepository.findAllNewsWithCounters(pageable).stream().toList();
        return newsMapper.map(response);
    }

    @Override
    public NewsResponse getNewsById(Long id) {
        var news = newsRepository.findById(id).orElseThrow(() -> {
            log.error("Entity with id {0} not found", id);
            throw new EntityNotFoundException("Entity with id " + id + " not found");
                }
        );
        return newsMapper.mapToResponse(news);
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CommonUpsertResponse create(NewsCreateRequest newsCreateRequest) {
        var user = userRepository.getById(UserUtils.SYSTEM_USER_ID); //todo: after test & make auth
        var news = newsMapper.map(newsCreateRequest);
        var category = categoryRepository.getById(newsCreateRequest.categoryId());
        news.setCategory(category);
        news.setAuthor(user);
        var response = newsRepository.save(news);
        return newsMapper.mapToCommon(response);
    }

    @Override
    @Transactional
    public CommonUpsertResponse update(Long id, NewsUpdateRequest newsUpdateRequest) {
        var news = newsRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Entity with id {0} not found", id);
                    throw new EntityNotFoundException();
                }
        );
        newsMapper.update(newsUpdateRequest, news);
        return newsMapper.mapToCommon(news);
    }


}
