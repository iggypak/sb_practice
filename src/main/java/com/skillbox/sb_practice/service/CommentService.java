package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.comments.CommentResponse;
import com.skillbox.sb_practice.dto.comments.CommentUpsertRequest;

import java.util.List;


public interface CommentService {
    List<CommentResponse> commentByNewsId(Long id);
    CommentResponse addComment(CommentUpsertRequest request);
    void deleteComment(Long id);
    void updateComment(CommentUpsertRequest request);
    CommentResponse getCommentById(Long id);
}
