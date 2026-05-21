package com.likelion14.session.auth.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("비밀번호가 잂치하지 않습니다");
    }
}
