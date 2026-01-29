package com.example.studentmanager;

import java.util.UUID;

import jakarta.persistence.Column; // Bắt buộc phải import thư viện này
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SinhVien")
public class Student {
    
    @Id
    /* QUAN TRỌNG: Với SQL Server, dùng GenerationType.AUTO hoặc 
       không cần strategy nếu bạn đã để DEFAULT NEWSEQUENTIALID() ở DB.
    */
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uniqueidentifier")
    private UUID id; // 1. Thay 'int' thành 'UUID'
    
    private String name;
    private int age;

    // Constructor rỗng (Bắt buộc cho Hibernate)
    public Student() {}

    // 2. Constructor đầy đủ: Thay 'int id' thành 'UUID id'
    public Student(UUID id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 3. Getter và Setter: Thay 'int' thành 'UUID'
    public UUID getId() { 
        return id; 
    }
    
    public void setId(UUID id) { 
        this.id = id; 
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}