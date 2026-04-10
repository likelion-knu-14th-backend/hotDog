package com.likelion14.session.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String userId;
    private String userPw;
    private String userName;
    private Integer age;
    @Column(unique = true, nullable = false) //전화번호 중복 막기
    private String phoneNum;

    public User(String userId, String userName, String userPw, Integer age, String phoneNum) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.age = age;
        this.phoneNum = phoneNum;
    }

    public void update(String userId, String userPw, String userName, Integer age, String phoneNum) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.age = age;
        this.phoneNum = phoneNum;
    }
}
