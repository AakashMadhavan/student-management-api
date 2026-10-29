package com.example.student_management;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsByEmail(String email);
    Optional<Student> findByEmail(String email);
}
