package com.example.studentmanager;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lab2Controller {

    @Autowired
    private StudentRepository studentRepository;

    // 1. Xem danh sách (Có xử lý tìm kiếm)
    @GetMapping("/students")
    public String listStudents(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Student> list;
        if (keyword != null && !keyword.isEmpty()) {
            // Nếu có từ khóa thì tìm theo tên
            list = studentRepository.findByNameContaining(keyword);
        } else {
            // Không có thì lấy hết
            list = studentRepository.findAll();
        }
        model.addAttribute("students", list);
        model.addAttribute("keyword", keyword); // Để giữ lại từ khóa trong ô input
        return "students";
    }

    // 2. Form thêm mới
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "form_student";
    }

    // 3. Form sửa
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable UUID id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).orElse(null));
        return "form_student";
    }

    // 4. Lưu
    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    // 5. Xóa
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
    // 6. Xem chi tiết sinh viên
    @GetMapping("/students/detail/{id}")
    public String viewStudentDetail(@PathVariable UUID id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        model.addAttribute("student", student);
        return "student_detail"; // Trả về file student_detail.html
    }
    // Trang chủ nhảy về danh sách
    @GetMapping("/")
    public String home() { return "redirect:/students"; }
}