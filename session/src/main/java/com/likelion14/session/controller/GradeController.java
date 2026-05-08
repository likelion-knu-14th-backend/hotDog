package com.likelion14.session.controller;

import com.likelion14.session.Dto.GradeRequestDto;
import com.likelion14.session.Dto.GradeResponseDto;
import com.likelion14.session.service.GradeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("/{studentNumber}")
    public void uploadStudentGrade(
            @PathVariable String studentNumber,
            @Valid @RequestBody List<GradeRequestDto> gradeRequestDtoList
    ) {
        gradeService.uploadStudentGrade(studentNumber, gradeRequestDtoList);
    }

    @GetMapping("/{studentNumber}")
    public List<GradeResponseDto> getStudentGrade(@PathVariable String studentNumber) {
        return gradeService.getStudentGrade(studentNumber);
    }
}
