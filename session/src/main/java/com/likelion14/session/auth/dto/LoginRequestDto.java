package com.likelion14.session.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    @NotBlank
    private String userID;

    @NotBlank
    private String password;
}
