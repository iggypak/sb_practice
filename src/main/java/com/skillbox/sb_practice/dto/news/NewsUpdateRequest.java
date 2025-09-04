package com.skillbox.sb_practice.dto.news;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record NewsUpdateRequest(
        @NotBlank
        @Size(min = 2, max = 255, message = "Размер заголовка должен быть в пределах 2 - 255 символов")
        String title,
        @NotBlank
        @Size(min = 10, message = "Размер новостного контента должен быть более 10 символов")
        String text,
        @Positive
        Long categoryId
) {}
