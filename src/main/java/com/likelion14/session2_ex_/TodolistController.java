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
                request.getTodoNumber()
        );

        todoList.add(todo);
        return todo;
    }

    @GetMapping
    public List<TodolistResponseDto> getTodoList() {
        return todoList;
    }

    @GetMapping("/{todoNumber}")
    public TodolistResponseDto getTodo(@PathVariable String todoNumber) {
        for (TodolistResponseDto todo : todoList) {
            if (todo.getTodoNumber().equals(todoNumber)) {
                return todo;
            }
        }
        return null;
    }

    @PutMapping("/{todoNumber}")
    public TodolistResponseDto updateTodo(
            @PathVariable String todoNumber,
            @RequestBody TodolistCreateRequestDto request
    ) {
        for (int i = 0; i < todoList.size(); i++) {
            TodolistResponseDto todo = todoList.get(i);

            if (todo.getTodoNumber().equals(todoNumber)) {
                TodolistResponseDto updatedTodo = new TodolistResponseDto(
                        request.getTodo1(),
                        request.getTodo2(),
                        request.getTodo3(),
                        request.getTodoNumber()
                );

                todoList.set(i, updatedTodo);
                return updatedTodo;
            }
        }

        return null;
    }

    @DeleteMapping("/{todoNumber}")
    public void deleteTodo(@PathVariable String todoNumber) {
        for (int i = 0; i < todoList.size(); i++) {
            TodolistResponseDto todo = todoList.get(i);

            if (todo.getTodoNumber().equals(todoNumber)) {
                todoList.remove(i);
            }
        }
    }
}

