package com.example.backend.security.services;


import com.example.backend.security.config.JwtService;
import com.example.backend.security.dto.AuthRequest;
import com.example.backend.security.dto.AuthResponse;
import com.example.backend.security.dto.RegisterRequest;
import com.example.backend.security.enums.Role;
import com.example.backend.users.entity.UserInfo;
import com.example.backend.users.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Builder
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        if (authentication.isAuthenticated()) {
            return AuthResponse.builder()
                    .accessToken(jwtService.generateToken(authRequest.username())).build();
        } else {
            throw new UsernameNotFoundException("invalid users request..!!");
        }
    }

    public AuthResponse register(RegisterRequest request) {
        var user = UserInfo.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.User)
                .build();

        repository.save(user);

        return authenticate(AuthRequest.builder()
                .username(request.username())
                .password(request.username())
                .build());
    }
}
