package com.skillbox.sb_practice.dto.comments;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        String text,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
