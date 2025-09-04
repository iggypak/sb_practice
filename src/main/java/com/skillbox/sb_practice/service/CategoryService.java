package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.categoies.CategoryRequest;
import com.skillbox.sb_practice.dto.categoies.CategoryResponse;
import com.skillbox.sb_practice.dto.comments.CommonUpsertResponse;
import com.skillbox.sb_practice.exceptions.EntityNotFoundException;
import com.skillbox.sb_practice.mapper.CategoryMapper;
import com.skillbox.sb_practice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    public CommonUpsertResponse createCategory(CategoryRequest request) {
        return mapper.mapToCommon(categoryRepository.save(mapper.map(request)));
    }

    public CommonUpsertResponse updateCategory(Long id, CategoryRequest request) {
        var category = categoryRepository.findById(id).orElseThrow(
                () -> {throw new EntityNotFoundException();}
        );
        mapper.update(request, category);
        categoryRepository.save(category);
        return mapper.mapToCommon(category);
    }

    public List<CategoryResponse> getAll() {
        return mapper.map(categoryRepository.findAll());
    }

    public CategoryResponse getById(Long id) {
        return mapper.map(categoryRepository.findById(id).orElseThrow(
                () -> {
                    throw new EntityNotFoundException();
                }
        ));
    }
}
