package com.skillbox.sb_practice.dto;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateRequest(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotBlank
        String username
) {}
