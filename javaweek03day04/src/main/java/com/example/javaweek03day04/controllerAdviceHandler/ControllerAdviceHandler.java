package com.example.javaweek03day04.controllerAdviceHandler;

import com.example.javaweek03day04.exceptions.ClassroomNotFoundException;
import com.example.javaweek03day04.exceptions.StudentNotFoundException;
import com.example.javaweek03day04.exceptions.TeacherNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceHandler {
    Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        logger.warn("MethodArgumentNotValidException => provoked!");
        return ResponseEntity.status(400).body(methodArgumentNotValidException.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<?> DataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException){
        logger.warn("DataIntegrityViolationException => provoked!");
        return ResponseEntity.status(400).body(dataIntegrityViolationException.getRootCause().getMessage());
    }

    @ExceptionHandler(value = ClassroomNotFoundException.class)
    public ResponseEntity<?> ClassroomNotFoundException(ClassroomNotFoundException ex){
        logger.warn("ClassroomNotFoundException => provoked!");
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(value = TeacherNotFoundException.class)
    public ResponseEntity<?> TeacherNotFoundException(TeacherNotFoundException ex){
        logger.warn("TeacherNotFoundException => provoked!");
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<?> StudentNotFoundException(StudentNotFoundException ex){
        logger.warn("StudentNotFoundException => provoked!");
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> Exception(Exception e) {
        logger.warn("Exception => provoked!");
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
