package com.example.uni.controller;

import com.example.uni.model.Student;
import com.example.uni.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@CrossOrigin("http://localhost:3000/")
public class StudentController {
    StudentService studentService;
    @Autowired
    StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping
    List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("{id}")
    Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
    @PostMapping("search")
    List<Student> searchStudents(@RequestBody Student student){
        return studentService.searchStudents(student);
    }
    @PostMapping
    Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @DeleteMapping("{id}")
    void deleteStudent(@PathVariable Long id){
         studentService.deleteStudent(id);
    }

}
