package com.example.session.controller;

import com.example.session.dto.TodoCreateRequestDto;
import com.example.session.dto.TodoResponseDto;
import com.example.session.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoCreateRequestDto request) {
        return todoService.createTodo(request);
    }

    @GetMapping
    public List<TodoResponseDto> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/{todoNumber}")
    public TodoResponseDto getTodo(@PathVariable String todoNumber) {
        return todoService.getTodo(todoNumber);
    }

    @PutMapping("/{todoNumber}")
    public TodoResponseDto updateTodo(
            @PathVariable String todoNumber,
            @RequestBody TodoCreateRequestDto request
    ) {
        return todoService.updateTodo(todoNumber, request);
    }

    @DeleteMapping("/{todoNumber}")
    public void deleteTodo(@PathVariable String todoNumber) {
        todoService.deleteTodo(todoNumber);
    }
}