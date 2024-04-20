package com.assigment.assigment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.assigment.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUserId(Long userId);
}

