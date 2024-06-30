package com.example.studentapi.controller;


import com.example.studentapi.model.Student;
import com.example.studentapi.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Long> create(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.ok(student.getStudentId());
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity update(@RequestBody Student student) {
        studentService.update(student);
        return ResponseEntity.ok().build();
    }


    @Getter
    @Setter
    static class AddStudentDto {
        private Long studentId;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
