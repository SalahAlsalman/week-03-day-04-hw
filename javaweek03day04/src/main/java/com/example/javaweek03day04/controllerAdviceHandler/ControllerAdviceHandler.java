package com.example.javaweek03day04.controllerAdviceHandler;

import com.example.javaweek03day04.exceptions.ClassroomNotFoundException;
import com.example.javaweek03day04.exceptions.StudentNotFoundException;
import com.example.javaweek03day04.exceptions.TeacherNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity.status(400).body(methodArgumentNotValidException.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<?> DataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException){
        return ResponseEntity.status(400).body(dataIntegrityViolationException.getRootCause().getMessage());
    }

    @ExceptionHandler(value = ClassroomNotFoundException.class)
    public ResponseEntity<?> ClassroomNotFoundException(ClassroomNotFoundException ex){
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(value = TeacherNotFoundException.class)
    public ResponseEntity<?> TeacherNotFoundException(TeacherNotFoundException ex){
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<?> StudentNotFoundException(StudentNotFoundException ex){
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> Exception(Exception e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
