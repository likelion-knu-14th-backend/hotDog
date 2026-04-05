package com.likelion14.session;


import com.likelion14.session.Dto.UserCreateRequestDto;
import com.likelion14.session.Dto.UserResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final List<UserResponseDto> userStore = new ArrayList<>();


    @PostMapping //회원가입
    public UserResponseDto createUser(@RequestBody UserCreateRequestDto userRequest){

        UserResponseDto user = new UserResponseDto(
                userRequest.getUserId(),
                userRequest.getUserPw(),
                userRequest.getUserName(),
                userRequest.getAge(),
                userRequest.getPhoneNum()
        );
        userStore.add(user);

        return user;
    }

    @GetMapping //회원전체 조회
    public List<UserResponseDto> getUsers() {return userStore;}

    @GetMapping("/{userId}") //회원 Id로 해당 회원 조회
    public UserResponseDto getUser(@PathVariable String userId){
        for(UserResponseDto user : userStore){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }
    @PutMapping("/{userId}") //회원 Id로 해당 회원정보 전체 수정
    public UserResponseDto updateUser(@PathVariable String userId,@RequestBody UserCreateRequestDto request){
        for(int i = 0; i < userStore.size(); i++){
            if(userStore.get(i).getUserId().equals(userId)){
                UserResponseDto updateUser = new UserResponseDto(
                        request.getUserId(),
                        request.getUserPw(),
                        request.getUserName(),
                        request.getAge(),
                        request.getPhoneNum()
                );
                userStore.set(i,updateUser);
                return updateUser;
            }
        }
        return null;

    }
    @DeleteMapping("/{userId}") //회원 Id로 해당 회원 탈퇴
    public void deleteStudent(@PathVariable String userId) {
        for (int i = 0; i < userStore.size(); i++) {

            if (userStore.get(i).getUserId().equals(userId)) {
                userStore.remove(i);
            }
        }
    }

}
