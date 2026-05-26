package com.likelion14.session.controller;


import com.likelion14.session.Dto.group.GroupResponseDto;
import com.likelion14.session.Dto.user.UserSignUpRequestDto;
import com.likelion14.session.Dto.user.UserResponseDto;
import com.likelion14.session.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

  /*  @PostMapping //회원가입
    public UserResponseDto createUser(@RequestBody @Valid UserCreateRequestDto userRequest){
        return userService.createUser(userRequest);
    }*/

    @GetMapping //회원전체 조회
    public List<UserResponseDto> getUsers() {return userService.getUserList();}

    @GetMapping("/{userId}") //회원 Id로 해당 회원 조회
    public UserResponseDto getUser(@PathVariable String userId){
         return userService.getUser(userId);
    }
    @PutMapping("/{userId}") //회원 Id로 해당 회원정보 전체 수정
    public UserResponseDto updateUser(@PathVariable String userId,@RequestBody @Valid UserSignUpRequestDto request){
        return userService.updateUser(userId,request);
    }
    @DeleteMapping("/{userId}") //회원 Id로 해당 회원 탈퇴
    public void deleteStudent(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/{userId}/group")
    public GroupResponseDto getMyGroup(@PathVariable String userId) {
        return userService.getMyGroup(userId);
    }//회원 Id로 해당 회원 조회

}
