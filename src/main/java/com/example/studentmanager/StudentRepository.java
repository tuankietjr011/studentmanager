package com.example.studentmanager;

import java.util.List;
import java.util.UUID; // 1. Thêm import này

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// 2. Đổi Integer thành UUID ở đây
public interface StudentRepository extends JpaRepository<Student, UUID> { 
    
    // Spring Boot vẫn tự động hiểu cách tìm kiếm theo tên, không cần sửa dòng này!
    List<Student> findByNameContaining(String name);
}