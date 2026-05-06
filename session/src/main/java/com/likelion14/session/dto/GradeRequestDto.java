package com.likelion14.session.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class GradeRequestDto {
    private String subjectName;
    private String grade;
}