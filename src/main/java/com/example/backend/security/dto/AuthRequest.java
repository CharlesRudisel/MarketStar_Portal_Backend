package com.example.backend.security.dto;

import lombok.Builder;

@Builder
public record AuthRequest(
        String username,
        String password

) {

}
