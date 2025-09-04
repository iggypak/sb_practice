package com.skillbox.sb_practice.dto.news;

import com.skillbox.sb_practice.dto.comments.CommentResponse;

import java.time.LocalDateTime;
import java.util.List;

public record NewsResponse(
        Long id,
        String title,
        String text,
        String author,
        String category,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<CommentResponse> commentResponseList
) {}
