package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findByName(String name);
}
