package com.example.uni.service;

import com.example.uni.model.Student;
import com.example.uni.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.persistence.criteria.Predicate;

@Service
public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository;
    @Autowired
    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;

    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {

        studentRepository.delete(getStudent(id));
    }

    @Override
    public List<Student> searchStudents(Student student) {
        return studentRepository.findAll(((root, query, cb) -> {
            Predicate predicate=cb.conjunction();
            if(student.getFirstName()!=null){
                predicate=cb.and(predicate,cb.like(root.get("firstName"),"%".concat(student.getFirstName().concat("%"))));
            }
            if(student.getLastName()!=null){
                predicate=cb.and(predicate,cb.like(root.get("lastName"),"%".concat(student.getLastName().concat("%"))));
            }
            if (student.getEmail()!=null){
                predicate=cb.and(predicate,cb.like(root.get("firstName"),"%".concat(student.getEmail().concat("%"))));
            }
            if (student.getPersonalNo()!=null){
                predicate=cb.and(predicate,cb.like(root.get("personalNo"),"%".concat(student.getPersonalNo().concat("%"))));
            }
            if(student.getBirthDate()!=null){
                predicate=cb.and(predicate,cb.equal(root.get("birthDate"),student.getBirthDate()));
            }
            return predicate;



        }));
    }
}
