package com.skillbox.sb_practice.mapper;

import com.skillbox.sb_practice.dto.categoies.CategoryRequest;
import com.skillbox.sb_practice.dto.categoies.CategoryResponse;
import com.skillbox.sb_practice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends CommonMapper{
    Category map(CategoryRequest request);
    void update(CategoryRequest request, @MappingTarget Category category);
    CategoryResponse map(Category category);
    List<CategoryResponse> map(List<Category>categories);
}
