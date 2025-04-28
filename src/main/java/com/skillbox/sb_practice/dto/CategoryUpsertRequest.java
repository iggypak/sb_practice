package com.skillbox.sb_practice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryUpsertRequest(
        @NotNull
        @Size(min = 1, max = 255)
        String name
) {}
