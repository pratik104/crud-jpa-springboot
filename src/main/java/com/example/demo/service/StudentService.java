package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student)
    {
         return studentRepository.save(student);
    }

    public Optional<Student> getStudent(Long id)
    {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
