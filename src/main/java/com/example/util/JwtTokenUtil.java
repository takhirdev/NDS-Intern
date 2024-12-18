package com.example.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenUtil {
    private static final int tokenLifeTime = 1000 * 3600 * 24 * 3; // 3-day
    private static final String secretKey = "c2VjcmV0X2tleV9mb3JfbGlicmFyeV9wcm9qZWN0";

    public static String encode(String username) {
        return Jwts.builder()
                .issuedAt(new Date())
                .signWith(getSignInKey())
                .claim("username", username)
                .expiration(new Date(System.currentTimeMillis() + (tokenLifeTime)))
                .issuer("library").compact();
    }

    public static String decodeUsername(String token) {
        Claims claims = Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return (String) claims.get("phone");
    }

    private static SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
