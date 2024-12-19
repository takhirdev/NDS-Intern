package com.example.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private static final int accessTokenLifeTime = 1000 * 3600 * 24 * 1; // 3-day
    private static final int refreshTokenLifeTime = 1000 * 3600 * 24 * 15; // 3-day
    private static final String secretKey = "c2VjcmV0X2tleV9mb3JfbGlicmFyeV9wcm9qZWN0";

    public String generateAccessToken(String username) {
        return generateToken(username, accessTokenLifeTime);
    }

    public String generateRefreshToken(String username) {
        return generateToken(username, refreshTokenLifeTime);
    }

    public String decodeUsername(String token) {
        Claims claims = Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return (String) claims.get("username");
    }

    private String generateToken(String username, int tokenLifeTime) {
        return Jwts.builder()
                .issuedAt(new Date())
                .signWith(getSignInKey())
                .claim("username", username)
                .expiration(new Date(System.currentTimeMillis() + tokenLifeTime))
                .issuer("library")
                .compact();
    }

    private static SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
