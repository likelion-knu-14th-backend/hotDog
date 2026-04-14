package com.example.session.dto;
import com.example.session.entity.Todo;

public class TodoResponseDto {

    private String todo;
    private String todoNumber;
    private Integer day;

    public TodoResponseDto(Todo todo) {
        this.todo = todo.getTodo();
        this.todoNumber = todo.getTodoNumber();
        this.day = todo.getDay();
    }
}
