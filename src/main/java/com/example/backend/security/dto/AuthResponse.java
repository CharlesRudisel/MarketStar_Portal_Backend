package com.example.backend.security.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String accessToken,
        Long userId,         // Added userId
        String username,     // Added username
        String roles         // Added roles
) {
}
