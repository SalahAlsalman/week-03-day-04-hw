package com.example.javaweek03day04.service;

import com.example.javaweek03day04.exceptions.ClassroomNotFoundException;
import com.example.javaweek03day04.exceptions.StudentNotFoundException;
import com.example.javaweek03day04.exceptions.TeacherNotFoundException;
import com.example.javaweek03day04.model.Classroom;
import com.example.javaweek03day04.model.Student;
import com.example.javaweek03day04.model.Teacher;
import com.example.javaweek03day04.repository.ClassroomRepository;
import com.example.javaweek03day04.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;
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

    public void addClassToStudent(Integer class_id, Integer student_id) {
        Classroom classroom = classroomRepository.findById(class_id).orElseThrow(()->{
            throw new ClassroomNotFoundException("Classroom id is wrong!");
        });

        Student student = studentRepository.findById(student_id).orElseThrow(()->{
            throw new TeacherNotFoundException("Student id is wrong");
        });
        if (classroom.getStudent().size() ==0) {
            classroom.setStudent(new HashSet<>());
        }
        classroom.getStudent().add(student);
        student.getClassroom().add(classroom);
        studentRepository.save(student);
    }
}
