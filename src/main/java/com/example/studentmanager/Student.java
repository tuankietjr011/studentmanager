package com.example.studentmanager;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "students") // Nên để tên thường, viết liền
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Để Auto cho lành, Postgres tự hiểu
    @Column(name = "id")
    private UUID id;

    private String name;
    private int age;

    public Student() {}

    public Student(UUID id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter & Setter
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}