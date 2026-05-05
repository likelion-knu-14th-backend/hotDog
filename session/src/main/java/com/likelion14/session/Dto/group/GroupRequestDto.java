package com.likelion14.session.Dto.group;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class GroupRequestDto {
    private String name;
    private Integer maxUserCount;
}
