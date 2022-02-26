package com.example.uni.controller;

import com.example.uni.model.Teacher;
import com.example.uni.model.Teacher;
import com.example.uni.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
@CrossOrigin("http://localhost:3000/")
public class TeacherController {
    TeacherService teacherService;
    @Autowired
    TeacherController(TeacherService teacherService){
        this.teacherService=teacherService;
    }
    @GetMapping
    List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
    @GetMapping("{id}")
    Teacher getTeacher(@PathVariable Long id){
        return teacherService.getTeacher(id);
    }
    @PostMapping("search")
    List<Teacher> searchTeachers(@RequestBody Teacher teacher){
        return teacherService.searchTeachers(teacher);
    }
    @PostMapping
    Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }
    @DeleteMapping("{id}")
    void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }
}
