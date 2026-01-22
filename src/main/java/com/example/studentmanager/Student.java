package com.example.studentmanager;

import jakarta.persistence.*; // Dùng dấu * để import hết các thư viện cần thiết

@Entity
@Table(name = "SinhVien")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <--- QUAN TRỌNG: Thêm dòng này để ID tự nhảy số (1, 2, 3...)
    private int id;
    
    private String name;
    private int age;

    // Constructor rỗng (Bắt buộc)
    public Student() {}

    // Constructor đầy đủ
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter và Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}