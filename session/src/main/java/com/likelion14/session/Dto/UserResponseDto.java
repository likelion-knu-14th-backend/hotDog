package com.likelion14.session.Dto;


import com.likelion14.session.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String userId;
    private String userPw;
    private String userName;
    private Integer age;
    private String phoneNum;


    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userName = user.getUserName();
        this.age = user.getAge();
        this.phoneNum = user.getPhoneNum();
    }
}
