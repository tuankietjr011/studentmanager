package com.example.studentmanager;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    private String name;
    private int age;
    
    // --- THÊM 2 CỘT MỚI Ở ĐÂY ---
    private String email;
    private String gender; 

    // Constructor rỗng (Bắt buộc)
    public Student() {}

    // Constructor đầy đủ (Cập nhật thêm email, gender)
    public Student(UUID id, String name, int age, String email, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    // --- GETTER & SETTER (Cũ) ---
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // --- GETTER & SETTER (Mới thêm) ---
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}