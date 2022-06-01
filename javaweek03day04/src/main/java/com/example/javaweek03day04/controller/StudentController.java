package com.example.javaweek03day04.controller;

import com.example.javaweek03day04.DTO.ResponseAPI;
import com.example.javaweek03day04.model.Student;
import com.example.javaweek03day04.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ResponseAPI<List<Student>>> getStudents(){
        return ResponseEntity.status(200).body(new ResponseAPI<>(studentService.getStudents(),200));
    }

    @GetMapping("getStudent/{id}")
    public ResponseEntity<ResponseAPI<Student>> getOneStudent(@PathVariable Integer id) {
        Student student = studentService.getOneStudent(id);
        return ResponseEntity.status(200).body(new ResponseAPI<>(student,200));
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<String>> addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new ResponseAPI<>("Student Added !", 201));
    }
}
