package com.likelion14.session.Dto.user;


import com.likelion14.session.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserResponseDto {
    private String userId;
    private String userPw;
    private String userName;
    private Integer age;
    private String phoneNum;
    private Long groupId;
    private String GroupName;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userName = user.getUserName();
        this.age = user.getAge();
        this.phoneNum = user.getPhoneNum();
        if(user.getTeamGroup()!=null){  //null point 에러 방지
            this.groupId = user.getTeamGroup().getId();
            this.GroupName = user.getTeamGroup().getName();
        }
    }
}
