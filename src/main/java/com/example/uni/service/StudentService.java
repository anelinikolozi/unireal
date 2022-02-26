package com.example.uni.service;

import com.example.uni.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudent(Long id);

    Student addStudent(Student student);

    void deleteStudent(Long id);

    List<Student> searchStudents(Student student);
}
