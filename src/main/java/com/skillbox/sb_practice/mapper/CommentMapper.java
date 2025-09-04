package com.skillbox.sb_practice.mapper;

import com.skillbox.sb_practice.dto.comments.CommentResponse;
import com.skillbox.sb_practice.dto.comments.CommentUpsertRequest;
import com.skillbox.sb_practice.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper extends CommonMapper {
    CommentResponse map(Comment response);
    void update(CommentUpsertRequest request, @MappingTarget Comment category);
    Comment map(CommentUpsertRequest commentUpsertRequest);
    List<CommentResponse> map(List<Comment>categories);
}
