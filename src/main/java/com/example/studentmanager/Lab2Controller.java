package com.example.studentmanager;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin; // Import sao (*) cho gọn
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // QUAN TRỌNG: Để cho phép test từ mọi nơi
public class Lab2Controller {

    @Autowired
    private StudentRepository studentRepository;

    // Lấy danh sách
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    // Thêm mới
    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Xóa (Sửa thành @DeleteMapping chuẩn chỉ)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        studentRepository.deleteById(id);
    }

    // Xem chi tiết
    @GetMapping("/{id}")
    public Student getDetail(@PathVariable UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Tìm kiếm
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentRepository.findByNameContaining(name);
    }

    // Sửa (Sửa thành @PutMapping chuẩn chỉ)
    @PutMapping("/{id}")
    public Student update(@PathVariable UUID id, @RequestBody Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            return studentRepository.save(existingStudent);
        }
        return null;
    }
}