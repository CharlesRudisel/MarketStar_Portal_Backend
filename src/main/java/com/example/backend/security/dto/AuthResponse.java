package com.example.backend.security.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String accessToken
) {
}
