package com.likelion14.session.controller;


import com.likelion14.session.Dto.UserCreateRequestDto;
import com.likelion14.session.Dto.UserResponseDto;
import com.likelion14.session.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping //회원가입
    public UserResponseDto createUser(@RequestBody UserCreateRequestDto userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping //회원전체 조회
    public List<UserResponseDto> getUsers() {return userService.getUserList();}

    @GetMapping("/{userId}") //회원 Id로 해당 회원 조회
    public UserResponseDto getUser(@PathVariable String userId){
         return userService.getUser(userId);
    }
    @PutMapping("/{userId}") //회원 Id로 해당 회원정보 전체 수정
    public UserResponseDto updateUser(@PathVariable String userId,@RequestBody UserCreateRequestDto request){
        return userService.updateUser(userId,request);

    }
    @DeleteMapping("/{userId}") //회원 Id로 해당 회원 탈퇴
    public void deleteStudent(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
