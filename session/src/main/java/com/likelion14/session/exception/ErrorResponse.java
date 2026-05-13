package com.likelion14.session.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(
        String code,
        String message
) {
}
