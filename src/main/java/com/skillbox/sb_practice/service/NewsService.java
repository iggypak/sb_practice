package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.comments.CommonUpsertResponse;
import com.skillbox.sb_practice.dto.news.NewsCreateRequest;
import com.skillbox.sb_practice.dto.news.NewsResponse;
import com.skillbox.sb_practice.dto.news.NewsResponseItem;
import com.skillbox.sb_practice.dto.news.NewsUpdateRequest;

import java.util.List;

public interface NewsService {
    List<NewsResponseItem> getAllNewsByPage(int size, int page);
    NewsResponse getNewsById(Long id);
    void deleteById(Long id);
    CommonUpsertResponse create(NewsCreateRequest newsCreateRequest);
    CommonUpsertResponse update(Long id, NewsUpdateRequest newsUpdateRequest);
}
