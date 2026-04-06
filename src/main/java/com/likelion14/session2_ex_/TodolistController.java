package com.likelion14.session2_ex_;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodolistController {

    private final List<TodolistResponseDto> todoList = new ArrayList<>();

    @PostMapping
    public TodolistResponseDto createTodo(@RequestBody TodolistCreateRequestDto request) {
        TodolistResponseDto todo = new TodolistResponseDto(
                request.getTodo1(),
                request.getTodo2(),
                request.getTodo3(),
                request.getDay()
        );

        todoList.add(todo);
        return todo;
    }

    @GetMapping
    public List<TodolistResponseDto> getTodoList() {
        return todoList;
    }

    @GetMapping("/{day}")
    public TodolistResponseDto getTodo(@PathVariable String day) {
        for (TodolistResponseDto todo : todoList) {
            if (todo.getDay().equals(day)) {
                return todo;
            }
        }
        return null;
    }

    @PutMapping("/{day}")
    public TodolistResponseDto updateTodo(
            @PathVariable String day,
            @RequestBody TodolistCreateRequestDto request
    ) {
        for (int i = 0; i < todoList.size(); i++) {
            TodolistResponseDto todo = todoList.get(i);

            if (todo.getDay().equals(day)) {
                TodolistResponseDto updatedTodo = new TodolistResponseDto(
                        request.getTodo1(),
                        request.getTodo2(),
                        request.getTodo3(),
                        request.getDay()
                );

                todoList.set(i, updatedTodo);
                return updatedTodo;
            }
        }

        return null;
    }

    @DeleteMapping("/{day}")
    public void deleteTodo(@PathVariable String day) {
        for (int i = 0; i < todoList.size(); i++) {
            TodolistResponseDto todo = todoList.get(i);

            if (todo.getDay().equals(day)) {
                todoList.remove(i);
            }
        }
    }
}

