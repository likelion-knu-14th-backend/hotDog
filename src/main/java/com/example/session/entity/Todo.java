package com.example.session.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todo;

    @Column(unique = true, nullable = false)
    private String todoNumber;
    private Integer day;

    public Todo(String todo, String todoNumber, Integer day) {
        this.todo = todo;
        this.todoNumber = todoNumber;
        this.day = day;
    }

    public void update(String todo, String todoNumber, Integer day) {
        this.todo = todo;
        this.todoNumber = todoNumber;
        this.day = day;
    }
}
