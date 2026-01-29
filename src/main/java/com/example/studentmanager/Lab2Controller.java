package com.example.studentmanager;

import java.util.List;
import java.util.UUID; // 1. Bắt buộc phải thêm import này

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class Lab2Controller {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // LỖI 1: Đổi 'int id' thành 'UUID id'
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        studentRepository.deleteById(id);
    }

    // LỖI 2: Đổi 'int id' thành 'UUID id'
    @GetMapping("/{id}")
    public Student getDetail(@PathVariable UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentRepository.findByNameContaining(name);
    }

    // LỖI 3 & 4: Đổi tham số nhận vào và biến tạm thành UUID
    @PostMapping("/update/{id}")
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