package com.example.studentmanager; // Nhớ kiểm tra lại tên package của bạn

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID; // BẮT BUỘC PHẢI CÓ DÒNG NÀY

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentRepository studentRepository;

    // 1. READ (GET) - Lấy toàn bộ danh sách sinh viên
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 2. READ (GET) - Lấy thông tin chi tiết của 1 sinh viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id) { // Đã đổi thành UUID
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

    // 3. CREATE (POST) - Thêm mới 1 sinh viên
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // 4. UPDATE (PUT) - Cập nhật thông tin sinh viên theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable UUID id, @RequestBody Student studentDetails) { // Đã đổi thành UUID
        Optional<Student> studentOptional = studentRepository.findById(id);
        
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            // Cập nhật các thông tin mới
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            student.setEmail(studentDetails.getEmail());
            student.setGender(studentDetails.getGender());
            
            return ResponseEntity.ok(studentRepository.save(student));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. DELETE (DELETE) - Xóa 1 sinh viên theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) { // Đã đổi thành UUID
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build(); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}