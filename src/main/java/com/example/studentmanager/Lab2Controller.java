package com.example.studentmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

@Controller // Dùng cái này để trả về giao diện HTML
public class Lab2Controller {

    @Autowired
    private StudentRepository studentRepository;

    // 1. Trang danh sách sinh viên
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students"; // Trả về file students.html
    }

    // 2. Trang Form thêm mới
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student"; // Trả về file create_student.html
    }

    // 3. Xử lý lưu sinh viên (Thêm mới)
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/students"; // Lưu xong quay về trang danh sách
    }

    // 4. Trang Form chỉnh sửa
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable UUID id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).get());
        return "edit_student"; // Trả về file edit_student.html
    }

    // 5. Xử lý cập nhật sinh viên
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable UUID id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentRepository.findById(id).get();
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        
        studentRepository.save(existingStudent);
        return "redirect:/students";
    }

    // 6. Xử lý xóa sinh viên
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}