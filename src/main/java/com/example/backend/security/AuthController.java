package com.example.backend.security;

import com.example.backend.security.dto.AuthRequest;
import com.example.backend.security.dto.AuthResponse;
import com.example.backend.security.dto.RegisterRequest;
import com.example.backend.security.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(service.authenticate(authRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerAndGetToken(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }
}
