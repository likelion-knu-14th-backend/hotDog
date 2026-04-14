package com.example.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCreateRequestDto {

    private String todo;
    private String todoNumber;
    private Integer day;
}
