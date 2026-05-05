package com.likelion14.session.controller;

import com.likelion14.session.Dto.group.GroupRequestDto;
import com.likelion14.session.Dto.group.GroupResponseDto;
import com.likelion14.session.Dto.user.UserResponseDto;
import com.likelion14.session.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    @GetMapping("/{groupId}/users")
    public List<UserResponseDto> getUserByGroup(@PathVariable Long groupId){ //그룹에 속한 회원 조회
        return groupService.getUserByGroup(groupId);
    }
    @GetMapping
    public List<GroupResponseDto> getGroups(){return groupService.getGroups();}

    @PostMapping
    public GroupResponseDto createGroup(@RequestBody GroupRequestDto dto){
        return groupService.create(dto);
    }
    @PostMapping("/{groupId}/users/{userId}")
    public UserResponseDto addUserToGroup(@PathVariable Long groupId,@PathVariable String userId){
        return groupService.addUser(groupId,userId);
    }
    @DeleteMapping("/{groupId}/users/{userId}")
    public void deleteUserFromGroup(@PathVariable Long groupId,@PathVariable String userId){
        groupService.deleteUser(groupId,userId);
    }
    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId){
        groupService.deleteGroup(groupId);
    }

}
