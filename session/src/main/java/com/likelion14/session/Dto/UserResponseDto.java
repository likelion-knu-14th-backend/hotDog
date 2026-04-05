package com.likelion14.session.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private String userId;
    private String userPw;
    private String userName;
    private Integer age;
    private String phoneNum;
}
