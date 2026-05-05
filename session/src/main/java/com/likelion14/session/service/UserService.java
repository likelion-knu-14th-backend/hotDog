package com.likelion14.session.service;

import com.likelion14.session.Dto.user.UserCreateRequestDto;
import com.likelion14.session.Dto.user.UserResponseDto;
import com.likelion14.session.entity.User;
import com.likelion14.session.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserResponseDto createUser(UserCreateRequestDto dto){
        //UserGroup userGroup = userGroupRepository.findById(dto.getUserGroup_id()).orElseThrow(()->new IllegalArgumentException("존재하지 않은 그룹"));
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
        User user = getUserThrow(userId);
        return new UserResponseDto(user);
    }
    @Transactional
    public UserResponseDto updateUser(String userId,UserCreateRequestDto requestDto){
        User user = getUserThrow(userId);
        user.update(
                requestDto.getUserId(),
                requestDto.getUserPw(),
                requestDto.getUserName(),
                requestDto.getAge(),
                requestDto.getPhoneNum()
        );
        return new UserResponseDto(user);
    }
    @Transactional
    public void deleteUser(String userId){
        User user = getUserThrow(userId);
        userRepository.delete(user);
    }
    private User getUserThrow(String userId){
        return userRepository.findUserByUserId(userId)
                .orElseThrow(() ->new IllegalArgumentException("회원을 찾을 수 없습니다."));
    }
}
