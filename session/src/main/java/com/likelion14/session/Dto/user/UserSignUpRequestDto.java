package com.likelion14.session.Dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpRequestDto {
    @NotBlank(message = "아이디는 필수입니다.")
    private String userId; //User 아이디
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String userPw;  //비밀번호
    @NotBlank(message = "이름은 필수입니다.")
    private String userName; //이름
    @NotNull(message = "나이는 필수입니다.")
    @Positive(message = "나이는 양수여야 합니다.")
    private Integer age; //나이
    @NotBlank(message = "전화번호는 필수입니다.")
    private String phoneNum; //전화번호
}
