package com.example.javaweek03day04.service;

import com.example.javaweek03day04.exceptions.ClassroomNotFoundException;
import com.example.javaweek03day04.model.Classroom;
import com.example.javaweek03day04.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    public List<Classroom> getClasses() {
        return classroomRepository.findAll();
    }

    public void addClass(Classroom classroom) {
        classroom.setId(-1);
        classroomRepository.save(classroom);
    }

    public Classroom getOneClass(Integer id) {
        return classroomRepository.findById(id).orElseThrow(()->{
            throw new ClassroomNotFoundException("Class id is wrong!");
        });
    }
}
