package com.tur.jusus.controller;

import com.tur.jusus.config.jwt.JwtProvider;
import com.tur.jusus.dto.AuthRequestDto;
import com.tur.jusus.dto.AuthResponceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/auth")
    public AuthResponceDto auth(@RequestBody AuthRequestDto request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        if (passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            String token = jwtProvider.generateToken(userDetails.getUsername());
            return new AuthResponceDto(token);
        }
        return null;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
