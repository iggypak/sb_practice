package com.skillbox.sb_practice.dto.users;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String username,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        int countComments,
        int countNews
) {}
