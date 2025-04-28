package com.skillbox.sb_practice.dto;

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
