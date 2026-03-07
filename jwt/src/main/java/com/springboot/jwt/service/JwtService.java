package com.springboot.jwt.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    // 1 hour
    private static final long ACCESS_TOKEN_TTL_MS = 60 * 60 * 1000L;
    private final Key key;

    public JwtService(
            @Value("${security.jwt.secret:change-this-secret-at-least-32-chars-long!change-this-secret}") String secret) {
        // HS256 requires 256-bit (32+ chars) secret. Load from properties/env in prod.
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + ACCESS_TOKEN_TTL_MS);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims parseClaims(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token) // signed token parser (JWS)
                .getBody();
    }

    public String extractUserName(String token) throws JwtException {
        return parseClaims(token).getSubject();
    }

    public boolean isExpired(String token) {
        return parseClaims(token).getExpiration().before(new Date());
    }

    public boolean validate(String expectedUsername, String token) {
        try {
            return expectedUsername.equals(extractUserName(token)) && !isExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}