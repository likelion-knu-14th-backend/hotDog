package com.example.session.exception;

public record ErrorResponse(
        String code,
        String message
) {
}
