package com.springboot.jwt.web;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jwt.service.JwtService;
import com.springboot.jwt.web.dto.LoginRequest;

@RestController
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    // POST /api/login  (Content-Type: application/json)
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        // Demo only: hardcoded credentials. Replace with real user validation.
        if ("admin".equals(req.getUser()) && "admin".equals(req.getPassword())) {
            String token = jwtService.generateToken(req.getUser());
            return ResponseEntity.ok(Map.of(
                    "tokenType", "Bearer",
                    "accessToken", token
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid Username/Password"));
    }
}
