package com.example.session.service;

import com.example.session.dto.TodoCreateRequestDto;
import com.example.session.dto.TodoResponseDto;
import com.example.session.entity.Todo;
import com.example.session.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoCreateRequestDto request) {
        Todo todo = new Todo(
                request.getTodo(),
                request.getTodoNumber(),
                request.getDay()
        );

        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponseDto(savedTodo);
    }

    public List<TodoResponseDto> getTodos() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponseDto::new)
                .toList();
    }

    public TodoResponseDto getTodo(String todoNumber) {
        Todo todo = todoRepository.findByTodoNumber(todoNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다."));

        return new TodoResponseDto(todo);
    }

    public TodoResponseDto updateTodo(String todoNumber, TodoCreateRequestDto request) {
        Todo todo = todoRepository.findByTodoNumber(todoNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 번호가 존재하지 않습니다."));

        todo.update(
                request.getTodo(),
                request.getTodoNumber(),
                request.getDay()
        );

        Todo updatedTodo = todoRepository.save(todo);
        return new TodoResponseDto(updatedTodo);
    }

    public void deleteTodo(String todoNumber) {
        Todo todo = todoRepository.findByTodoNumber(todoNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 번호가 존재하지 않습니다."));

        todoRepository.delete(todo);
    }
}