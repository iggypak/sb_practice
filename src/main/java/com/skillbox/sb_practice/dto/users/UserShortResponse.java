package com.skillbox.sb_practice.dto.users;

public record UserShortResponse(
        String username,
        Long id,
        int countComments,
        int countNews
        ) {}
