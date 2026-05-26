package com.example.session.repository;

import com.example.session.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentNumber(String studentNumber);

    boolean existsByEmail(String email);

    Optional<Student> findByEmail(String email);
}
