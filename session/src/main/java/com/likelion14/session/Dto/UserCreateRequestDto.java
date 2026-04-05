package com.likelion14.session.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {
    private String userId; //User 아이디
    private String userPw;  //비밀번호
    private String userName; //이름
    private Integer age; //나이
    private String phoneNum; //전화번호
}
