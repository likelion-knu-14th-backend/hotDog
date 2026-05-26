package com.likelion14.session.auth.controller;

import com.likelion14.session.Dto.user.UserSignUpRequestDto;
import com.likelion14.session.auth.AuthService;
import com.likelion14.session.auth.dto.LoginRequestDto;
import com.likelion14.session.auth.dto.TokenResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(
            @Valid @RequestBody UserSignUpRequestDto request
    ) {
        authService.signup(request);
        return "회원가입 성공";
    }
    @PostMapping("/login")
    public TokenResponseDto login(
            @Valid @RequestBody LoginRequestDto request
    ) {
        return authService.login(request);
    }
}
