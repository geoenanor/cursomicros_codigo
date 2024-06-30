package com.example.studentapi.service;


import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;



    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void update(Student student) {
        if (studentRepository.existsById(student.getStudentId())) {
            studentRepository.save(student);
        }
    }

}
