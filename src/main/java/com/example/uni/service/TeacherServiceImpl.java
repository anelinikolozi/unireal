package com.example.uni.service;


import com.example.uni.model.Teacher;

import com.example.uni.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    TeacherRepository teacherRepository;
    @Autowired
    TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;

    }
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {

        teacherRepository.delete(getTeacher(id));
    }

    @Override
    public List<Teacher> searchTeachers(Teacher teacher) {
        return teacherRepository.findAll(((root, query, cb) -> {
            Predicate predicate=cb.conjunction();
            if(teacher.getFirstName()!=null){
                predicate=cb.and(predicate,cb.like(root.get("firstName"),"%".concat(teacher.getFirstName().concat("%"))));
            }
            if(teacher.getLastName()!=null){
                predicate=cb.and(predicate,cb.like(root.get("lastName"),"%".concat(teacher.getLastName().concat("%"))));
            }
            if (teacher.getEmail()!=null){
                predicate=cb.and(predicate,cb.like(root.get("firstName"),"%".concat(teacher.getEmail().concat("%"))));
            }
            if (teacher.getPersonalNo()!=null){
                predicate=cb.and(predicate,cb.like(root.get("personalNo"),"%".concat(teacher.getPersonalNo().concat("%"))));
            }
            if(teacher.getBirthDate()!=null){
                predicate=cb.and(predicate,cb.equal(root.get("birthDate"),teacher.getBirthDate()));
            }
            return predicate;
        }));
    }
}
