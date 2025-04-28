package com.skillbox.sb_practice.dto;


import java.time.LocalDateTime;

public record NewsResponseItem(
        Long id,
        String title,
        String text,
        UserShortResponse author,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        int countComments,
        String categoryName
) {}
