package com.skillbox.sb_practice.mapper;

import com.skillbox.sb_practice.dto.NewsCreateRequest;
import com.skillbox.sb_practice.dto.NewsResponse;
import com.skillbox.sb_practice.dto.NewsResponseItem;
import com.skillbox.sb_practice.dto.NewsUpdateRequest;
import com.skillbox.sb_practice.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface NewsMapper extends CommonMapper{
    @Mapping(target = "author", source = "author")
    NewsResponseItem map(News news);
    @Mapping(target = "author", source = "author.username")
    @Mapping(target = "category", source = "category.name")
    NewsResponse mapToResponse(News news);
    News map(NewsCreateRequest newsCreateRequest);
    List<NewsResponseItem> map(List<News> newsList);
    void update(NewsUpdateRequest updateRequest, @MappingTarget News news);
}
