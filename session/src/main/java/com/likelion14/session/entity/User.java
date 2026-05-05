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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id",nullable = true)
    private TeamGroup teamGroup; //그룹이 없을 수도 있음.



    public User(String userId, String userPw,String userName, Integer age, String phoneNum) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
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
    public void groupUpdate(TeamGroup teamGroup){ //그룹만 변경
        this.groupRemove();
        this.teamGroup = teamGroup;
        if(teamGroup != null){
            teamGroup.getUsers().add(this);
        }
    }
    public void groupRemove(){ //그룹 탈퇴
        if(this.teamGroup != null){
            this.teamGroup.getUsers().remove(this);
        }
        this.teamGroup = null;
    }

}
