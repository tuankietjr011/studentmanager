package com.example.studentmanager;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Lab2Controller {

    @Autowired
    private StudentRepository studentRepository;

    // 1. Xem danh sách
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students"; // Trả về file students.html
    }

    // 2. Mở form thêm mới
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        // Tạo sinh viên rỗng để điền form
        Student student = new Student();
        model.addAttribute("student", student);
        return "form_student"; // Dùng chung 1 file form cho gọn
    }

    // 3. Mở form sửa (Lấy sinh viên cũ lên)
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable UUID id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        model.addAttribute("student", student);
        return "form_student"; // Dùng chung file form với lúc thêm mới
    }

    // 4. Xử lý LƯU (Dùng chung cho cả Thêm và Sửa)
    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // Nếu có ID -> Tự cập nhật. Nếu không có ID -> Tự thêm mới.
        studentRepository.save(student);
        return "redirect:/students";
    }

    // 5. Xử lý XÓA (Dùng GetMapping để bấm link là xóa ngay)
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}