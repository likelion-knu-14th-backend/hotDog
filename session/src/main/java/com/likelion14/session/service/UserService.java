package com.likelion14.session.service;

import com.likelion14.session.Dto.group.GroupResponseDto;
import com.likelion14.session.Dto.user.UserSignUpRequestDto;
import com.likelion14.session.Dto.user.UserResponseDto;
import com.likelion14.session.entity.User;
import com.likelion14.session.exception.ErrorCode;
import com.likelion14.session.exception.Exception;
import com.likelion14.session.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    /*@Transactional //하나의 작업 단위로 묶음
    public UserResponseDto createUser(UserSignUpRequestDto dto){
        User user = new User(
                dto.getUserId(),
                dto.getUserPw(),
                dto.getUserName(),
                dto.getAge(),
                dto.getPhoneNum()
        );
        return new UserResponseDto(userRepository.save(user));
    }*/
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
    public UserResponseDto updateUser(String userId, UserSignUpRequestDto requestDto){
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
            return userRepository.findUserByUserId(userId).orElseThrow(()->new Exception(ErrorCode.USER_NOT_FOUND));
    }

    public GroupResponseDto getMyGroup(String userId) {
        User user = getUserThrow(userId);
        if (user.getTeamGroup() == null) {
            return null;
        }
        return new GroupResponseDto(user.getTeamGroup());
    }
}
