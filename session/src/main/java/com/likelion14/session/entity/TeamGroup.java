package com.likelion14.session.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class TeamGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;


    private Integer maxUserCount; //최대인원


    @OneToMany(mappedBy = "teamGroup")
    private List<User> users = new ArrayList<>(); //양방향으로 처리

    public void addUser(User user){
        if(maxUserCount != null && maxUserCount <= users.size()){
            throw new IllegalArgumentException("그룹 최대인원 초과");
        }
        user.groupUpdate(this);
    }
    public void removeUser(User user){
        user.groupRemove();
    }
    public TeamGroup(String name, Integer maxUserCount){
        this.maxUserCount = maxUserCount;
        this.name = name;
    }
}
