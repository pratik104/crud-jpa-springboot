package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "add",produces = {"application/json"},consumes = {"application/json"})
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        Student s = studentService.addStudent(student);
        return new ResponseEntity<Student>(s,HttpStatus.CREATED);
    }

    @GetMapping(value="get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
    {
        Student student = studentService.getStudent(id).get();
        ResponseEntity<Student> studentResponse = new ResponseEntity<Student>(student, HttpStatus.OK);
        return studentResponse;
    }

    /*
    *   Put : Updates the entire resource.
    */
    @PutMapping(value= "/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student)
    {
        Student updateStudent = studentService.getStudent(id).orElseThrow(()->new RuntimeException("Resource Not Exist"));

        updateStudent.setName(student.getName());
        updateStudent.setDepartment(student.getDepartment());
        updateStudent.setPercentage(student.getPercentage());

        Student s = studentService.addStudent(updateStudent);
        return new ResponseEntity<Student>(s,HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id)
    {
        Student deleteStudent;
        try
        {
             deleteStudent = studentService.getStudent(id).orElseThrow(()-> new RuntimeException(" Resource Not Found"));
             studentService.deleteStudent(deleteStudent);
        }catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(deleteStudent,HttpStatus.OK);
    }
}
