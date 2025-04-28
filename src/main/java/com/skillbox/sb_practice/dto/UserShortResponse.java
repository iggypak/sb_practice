package com.skillbox.sb_practice.dto;

public record UserShortResponse(
        String username,
        Long id,
        int countComments,
        int countNews
        ) {}
