package com.likelion14.session.Dto.group;

import com.likelion14.session.entity.TeamGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GroupResponseDto {
    private Long groupId;
    private String name;
    private Integer maxUserCount;
    public GroupResponseDto(TeamGroup teamGroup){
        this.groupId = teamGroup.getId();
        this.name = teamGroup.getName();
        this.maxUserCount = teamGroup.getMaxUserCount();
    }
}
