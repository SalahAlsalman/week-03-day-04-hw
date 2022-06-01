package com.example.javaweek03day04.service;

import com.example.javaweek03day04.exceptions.StudentNotFoundException;
import com.example.javaweek03day04.model.Student;
import com.example.javaweek03day04.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        student.setId(-1);
        studentRepository.save(student);
    }

    public Student getOneStudent(Integer id) {
        return studentRepository.findById(id).orElseThrow(()->{
            throw new StudentNotFoundException("Student id is not correct!");
        });
    }
}
