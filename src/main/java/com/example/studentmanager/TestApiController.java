package com.example.studentmanager; // (Lưu ý: Đổi tên package này cho giống với file của bạn nếu cần)

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {

    // Đây là một API thực thụ, trả về dữ liệu thô (chữ) chứ không phải giao diện
    @GetMapping("/api/test")
    public String testApi() {
        return "Chào Kiệt! API đã kết nối thành công với Swagger!";
    }
}