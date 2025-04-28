package com.skillbox.sb_practice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record NewsFilterRequest(
        @NotBlank
        String title,
        @NotBlank
        String username,
        @PositiveOrZero
        int page,
        @Size(min = 1, max = 100)
        int size
) {
}
