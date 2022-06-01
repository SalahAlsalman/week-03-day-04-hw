package com.example.javaweek03day04.controller;

import com.example.javaweek03day04.DTO.ResponseAPI;
import com.example.javaweek03day04.model.Classroom;
import com.example.javaweek03day04.model.Student;
import com.example.javaweek03day04.model.Teacher;
import com.example.javaweek03day04.service.ClassroomService;
import com.example.javaweek03day04.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ResponseAPI<?>> getTeachers(){
        logger.info("getTeachers => called");
        return ResponseEntity.status(200).body(new ResponseAPI<>(teacherService.getTeachers(),200));
    }

    @GetMapping("getTeacher/{id}")
    public ResponseEntity<ResponseAPI<Teacher>> getOneTeacher(@PathVariable Integer id) {
        logger.info("getOneTeacher => called");
        Teacher teacher = teacherService.getOneTeacher(id);
        return ResponseEntity.status(200).body(new ResponseAPI<>(teacher,200));
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<?>> addTeacher(@RequestBody @Valid Teacher teacher) {
        logger.info("addTeacher => called");
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ResponseAPI<>("Teacher Added !", 201));
    }

    @PostMapping("/addClass")
    public ResponseEntity<ResponseAPI<?>> addClassToTeacher(@RequestParam Integer class_id, @RequestParam Integer teacher_id){
        logger.info("addClassToTeacher => called");
        teacherService.addClassToTeacher(class_id,teacher_id);
        return ResponseEntity.status(200).body(new ResponseAPI<>(String.format("Class: %s added to Teacher: %s", class_id, teacher_id),200));
    }
}
