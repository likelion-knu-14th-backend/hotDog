package com.example.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler2 {

    @ExceptionHandler(ShopNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerStudentNotFound(
            ShopNotFoundException e
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("SHOP_NOT_FOUND", e.getMessage()));
    }
}
