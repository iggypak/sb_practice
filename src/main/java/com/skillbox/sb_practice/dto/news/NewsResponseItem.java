package com.skillbox.sb_practice.dto.news;


import com.skillbox.sb_practice.dto.users.UserShortResponse;

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
