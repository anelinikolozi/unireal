package com.example.uni.service;


import com.example.uni.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<Teacher> getAllTeachers();

    Teacher getTeacher(Long id);

    List<Teacher> searchTeachers(Teacher teacher);

    Teacher addTeacher(Teacher teacher);

    void deleteTeacher(Long id);
}
