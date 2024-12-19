package com.example.dto.auth;

import lombok.Builder;

@Builder
public record AuthResponseDTO(
        Long id,
        String username,
        String accessToken,
        String refreshToken) {
}
