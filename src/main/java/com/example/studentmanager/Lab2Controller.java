package com.example.studentmanager;

import java.util.List;

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

    // Yêu cầu 5: Lấy danh sách (Get All) -> OK
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    // Yêu cầu 1: Thêm mới (POST) -> OK
    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Yêu cầu 2: Xóa sinh viên (Đề bắt dùng POST /delete/{id}) -> SỬA LẠI
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentRepository.deleteById(id);
    }

    // Yêu cầu 4: Lấy sinh viên theo ID -> OK
    @GetMapping("/{id}")
    public Student getDetail(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Yêu cầu 3: Tìm kiếm -> OK
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentRepository.findByNameContaining(name);
    }

    // Yêu cầu 6: Cập nhật (Đề bắt dùng POST /update/{id}) -> SỬA LẠI
    @PostMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            return studentRepository.save(existingStudent);
        }
        return null;
    }
}