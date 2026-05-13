package com.likelion14.session.Dto.group;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class GroupRequestDto {
    @NotBlank(message = "그룹 이름은 필수입니다.")
    private String name;
    @NotBlank(message = "인원 제한은 필수입니다.")
    private Integer maxUserCount;
}
