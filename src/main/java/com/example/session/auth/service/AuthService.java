package com.example.session.auth.service;

import com.example.session.auth.common.JwtTokenProvider;
import com.example.session.auth.dto.LoginRequestDto;
import com.example.session.auth.dto.SignupRequestDto;
import com.example.session.auth.dto.TokenResponseDto;
import com.example.session.auth.enums.Role;
import com.example.session.auth.exception.AlreadyEmailExistsException;
import com.example.session.auth.exception.InvalidPasswordException;
import com.example.session.entity.Student;
import com.example.session.exception.StudentNotFoundException;
import com.example.session.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void signup(SignupRequestDto request) {

        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyEmailExistsException();
        }

        Student student = new Student();
        student.setEmail(request.getEmail());

        student.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        student.setName(request.getName());
        student.setStudentNumber(request.getStudentNumber());
        student.setAge(request.getAge());
        student.setMajor(request.getMajor());

        student.setRole(Role.STUDENT);

        studentRepository.save(student);
    }

    public TokenResponseDto login(LoginRequestDto request) {
        Student student = studentRepository.findByEmail(request.getEmail())
                .orElseThrow(StudentNotFoundException::new);

        if (!passwordEncoder.matches(
                request.getPassword(),
                student.getPassword()
        )) {
            throw new InvalidPasswordException();
        }

        String accessToken = jwtTokenProvider.generateToken(student);

        return new TokenResponseDto(
                student.getName(),
                accessToken
        );
    }
}
