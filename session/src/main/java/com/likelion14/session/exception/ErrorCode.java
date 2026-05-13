package com.likelion14.session.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    GROUP_NOT_FOUND(HttpStatus.NOT_FOUND,"존재하지 않는 그룹입니다."),
    GROUP_NOT_USER(HttpStatus.NOT_FOUND,"해당 그룹의 회원이 아닙니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"존재하지 않는 유저입니다.");
    private final HttpStatus status;
    private final String message;
}
