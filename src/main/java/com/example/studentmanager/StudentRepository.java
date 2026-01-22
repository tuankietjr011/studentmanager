package com.example.studentmanager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Chỉ cần viết dòng này, Spring Boot sẽ tự động biết cách tìm kiếm theo tên!
    List<Student> findByNameContaining(String name);
}