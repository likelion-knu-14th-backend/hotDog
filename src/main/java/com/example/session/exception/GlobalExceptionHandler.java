package com.example.session.exception;

import com.example.session.auth.exception.AlreadyEmailExistsException;
import com.example.session.auth.exception.InvalidPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerStudentNotFound(
            StudentNotFoundException e
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("STUDENT_NOT_FOUND", e.getMessage()));
    }

    @ExceptionHandler(AlreadyEmailExistsException.class)
    public ResponseEntity<ErrorResponse> handlerEmailAlreadyExists(
            AlreadyEmailExistsException e
    ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("EMAIL_ALREADY_EXISTS", e.getMessage()));
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidPassword(
            InvalidPasswordException e
    ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("INVALID_PASSWORD", e.getMessage()));
    }
}
