package com.example.javaweek03day04.controller;

import com.example.javaweek03day04.DTO.ResponseAPI;
import com.example.javaweek03day04.model.Classroom;
import com.example.javaweek03day04.model.Student;
import com.example.javaweek03day04.model.Teacher;
import com.example.javaweek03day04.service.ClassroomService;
import com.example.javaweek03day04.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassroomService classroomService;

    @GetMapping
    public ResponseEntity<ResponseAPI<?>> getClasses(){
        return ResponseEntity.status(200).body(new ResponseAPI<>(classroomService.getClasses(),200));
    }

    @GetMapping("getClass/{id}")
    public ResponseEntity<ResponseAPI<Classroom>> getOneClass(@PathVariable Integer id) {
        Classroom classroom = classroomService.getOneClass(id);
        return ResponseEntity.status(200).body(new ResponseAPI<>(classroom,200));
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<?>> addClass(@RequestBody @Valid Classroom classroom) {
        classroomService.addClass(classroom);
        return ResponseEntity.status(201).body(new ResponseAPI<>("Classroom Added !", 201));
    }
}
