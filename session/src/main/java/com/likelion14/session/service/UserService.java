package com.likelion14.session.service;

import com.likelion14.session.Dto.UserCreateRequestDto;
import com.likelion14.session.Dto.UserResponseDto;
import com.likelion14.session.entity.User;
import com.likelion14.session.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserResponseDto createUser(UserCreateRequestDto dto){
        User user = new User(
                dto.getUserId(),
                dto.getUserPw(),
                dto.getUserName(),
                dto.getAge(),
                dto.getPhoneNum()
        );
        return new UserResponseDto(userRepository.save(user));
    }
    public List<UserResponseDto> getUserList(){
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto :: new)
                .toList();
    }
    public UserResponseDto getUser(String userId){
        User user = userRepository.findUserByUserId(userId)
                .orElseThrow(() ->new IllegalArgumentException("회원을 찾을 수 없습니다."));

        return new UserResponseDto(user);
    }
    public UserResponseDto updateUser(String userId,UserCreateRequestDto requestDto){
        User user = userRepository.findUserByUserId(userId)
                .orElseThrow(() ->new IllegalArgumentException("회원을 찾을 수 없습니다."));
        user.update(
                requestDto.getUserId(),
                requestDto.getUserPw(),
                requestDto.getUserName(),
                requestDto.getAge(),
                requestDto.getPhoneNum()
        );
        User updatedStudent = userRepository.save(user);
        return new UserResponseDto(updatedStudent);
    }
    public void deleteUser(String userId){
        User user = userRepository.findUserByUserId(userId)
                .orElseThrow(() ->new IllegalArgumentException("회원을 찾을 수 없습니다."));
        userRepository.delete(user);
    }

}
