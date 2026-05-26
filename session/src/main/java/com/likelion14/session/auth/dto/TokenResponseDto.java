package com.likelion14.session.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponseDto {
    private String name;
    // 발급된 JWT
    private String accessToken;
}
