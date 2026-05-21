package com.example.studentmanager; // Nhớ đổi tên package nếu của bạn khác nhé

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // Đánh dấu đây là API trả về JSON
@RequestMapping("/api/students") // Đặt tên đường link gốc
public class StudentApiController {

    @Autowired
    private StudentRepository studentRepository; // Gọi "két sắt" Database ra

    // Lệnh GET: Lấy toàn bộ danh sách sinh viên
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // Trả thẳng dữ liệu thô ra ngoài
    }
}