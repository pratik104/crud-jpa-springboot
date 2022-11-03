package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Department department;
    private Double percentage;

    public Student() {
    }

    public Student(Long id, String name, Department department, Double percentage) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", percentage=" + percentage +
                '}';
    }
}
