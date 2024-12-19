package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.auth.AuthResponseDTO;
import com.example.dto.auth.LoginDTO;
import com.example.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.example.util.ApiUrls.AUTH_URL;

@RestController
@RequestMapping(AUTH_URL)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // login
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> login(@Valid @RequestBody LoginDTO dto) {
        return ResponseEntity.ok().body(authService.login(dto));
    }

    // refresh token
    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> refreshToken(@RequestBody String refreshToken) {
        return ResponseEntity.ok().body(authService.refreshToken(refreshToken));
    }
}
