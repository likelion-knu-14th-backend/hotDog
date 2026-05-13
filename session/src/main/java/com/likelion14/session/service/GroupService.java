package com.likelion14.session.service;

import com.likelion14.session.Dto.group.GroupRequestDto;
import com.likelion14.session.Dto.group.GroupResponseDto;
import com.likelion14.session.Dto.user.UserResponseDto;
import com.likelion14.session.entity.TeamGroup;
import com.likelion14.session.entity.User;
import com.likelion14.session.exception.ErrorCode;
import com.likelion14.session.exception.Exception;
import com.likelion14.session.repository.GroupRepository;
import com.likelion14.session.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
//코드가 생각보다 깔끔하지 않아서 좀더 수정 해야할 필요가 있다.
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    public List<GroupResponseDto> getGroups(){
        return groupRepository.findAll()
                .stream()
                .map(GroupResponseDto::new)
                .toList();
    }
    @Transactional
    public GroupResponseDto create(GroupRequestDto dto) {
        TeamGroup newTeamGroup = new TeamGroup(
                dto.getName(),
                dto.getMaxUserCount()
        );
        return new GroupResponseDto(groupRepository.save(newTeamGroup));
    }
    public List<UserResponseDto> getUserByGroup(Long groupId){
        TeamGroup teamGroup = getGroupThrow(groupId);
        return teamGroup.getUsers()
                .stream()
                .map(UserResponseDto ::new)
                .toList();
    }
    @Transactional
    public UserResponseDto addUser(Long groupId, String userId) {
        TeamGroup teamGroup = getGroupThrow(groupId);
        User user = getUserThrow(userId);
        teamGroup.addUser(user);
        return new UserResponseDto(user);
    }
    @Transactional
    public void deleteUser(Long groupId, String userId) {
        TeamGroup teamGroup = getGroupThrow(groupId);
        User user = getUserThrow(userId);
        if(!user.getTeamGroup().getId().equals(groupId)){
            throw new Exception(ErrorCode.GROUP_NOT_USER);
        }
        teamGroup.removeUser(user);
    }
    @Transactional
    public void deleteGroup(Long groupId){
        TeamGroup teamGroup = getGroupThrow(groupId);
        List<User> users = new ArrayList<>(teamGroup.getUsers());
        for(User user : users){
            user.groupRemove();
        }
        groupRepository.delete(teamGroup);
    }

    private TeamGroup getGroupThrow(Long groupId){
        return groupRepository.findById(groupId).orElseThrow(()-> new Exception(ErrorCode.GROUP_NOT_FOUND));
    }
    private User getUserThrow(String userId){
        return userRepository.findUserByUserId(userId).orElseThrow(()->new Exception(ErrorCode.USER_NOT_FOUND));
    }
}
