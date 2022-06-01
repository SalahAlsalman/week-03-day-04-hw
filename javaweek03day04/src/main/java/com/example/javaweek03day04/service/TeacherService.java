package com.example.javaweek03day04.service;

import com.example.javaweek03day04.exceptions.ClassroomNotFoundException;
import com.example.javaweek03day04.exceptions.TeacherNotFoundException;
import com.example.javaweek03day04.model.Classroom;
import com.example.javaweek03day04.model.Student;
import com.example.javaweek03day04.model.Teacher;
import com.example.javaweek03day04.repository.ClassroomRepository;
import com.example.javaweek03day04.repository.StudentRepository;
import com.example.javaweek03day04.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final ClassroomRepository classroomRepository;
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacher.setId(-1);
        teacherRepository.save(teacher);
    }

    public Teacher getOneTeacher(Integer id) {
        return teacherRepository.findById(id).orElseThrow(()->{
            throw new TeacherNotFoundException("Teacher id is not correct!");
        });
    }


    public void addClassToTeacher(Integer class_id, Integer teacher_id) {
        Classroom classroom = classroomRepository.findById(class_id).orElseThrow(()->{
            throw new ClassroomNotFoundException("Classroom id is wrong!");
        });

        Teacher teacher = teacherRepository.findById(teacher_id).orElseThrow(()->{
           throw new TeacherNotFoundException("Teacher id is wrong");
        });
        if (classroom.getTeacher() != null) {
            throw new ClassroomNotFoundException("Classroom already has a teacher");
        }
        classroom.setTeacher(teacher);
        classroomRepository.save(classroom);
        if (teacher.getClassroom().size() == 0) {
            teacher.setClassroom(new HashSet<>());
        }
        teacher.getClassroom().add(classroom);
        teacherRepository.save(teacher);
    }
}
