package com.skillbox.sb_practice.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
        @NotNull
        @NotBlank
        @Size(min = 5, max = 40, message = "Имя пользователя должно быть в пределах 5 - 40 символов")
        String username,
        @NotNull
        @NotBlank
        @Size(min = 8, max = 255, message = "Пароль должен быть в пределах 8 - 255")
        String password,
        @NotNull
        @NotBlank
        @Size(min = 5, max = 255, message = "email должен быть в пределах 5 - 255")
        String email
) {}
