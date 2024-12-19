package com.example.service;

import com.example.dto.ApiResponse;
import com.example.dto.auth.AuthResponseDTO;
import com.example.dto.auth.LoginDTO;
import com.example.entity.LibrarianEntity;
import com.example.exception.ApiException;
import com.example.repository.LibrarianRepository;
import com.example.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final LibrarianRepository librarianRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // login
    public ApiResponse<AuthResponseDTO> login(LoginDTO dto) {
        var librarian = librarianRepository.findByUsername(dto.username())
                .orElseThrow(() -> new ApiException("username not found"));

        if (!passwordEncoder.matches(dto.password(), librarian.getPassword())) {
            throw new ApiException("password is incorrect");
        }

        return getAuthResponseDTO(librarian);
    }

    // refresh token
    public ApiResponse<AuthResponseDTO> refreshToken(String refreshToken) {
        String username = jwtUtil.decodeUsername(refreshToken);
        var librarian = librarianRepository.findByUsername(username)
                .orElseThrow(() -> new ApiException("librarian not found"));

        return getAuthResponseDTO(librarian);
    }

    private ApiResponse<AuthResponseDTO> getAuthResponseDTO(LibrarianEntity librarian) {
        return ApiResponse.ok(AuthResponseDTO.builder()
                .id(librarian.getId())
                .username(librarian.getUsername())
                .accessToken(jwtUtil.generateAccessToken(librarian.getUsername()))
                .refreshToken(jwtUtil.generateRefreshToken(librarian.getUsername()))
                .build());
    }
}
