package com.likelion14.session.Dto.group;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class GroupRequestDto {
    @NotBlank(message = "그룹 이름은 필수입니다.")
    private String name;
    @NotNull(message = "인원 제한은 필수입니다.")
    @Positive(message = "인원 제한 수는 양수여야 합니다.")
    private Integer maxUserCount;
}
