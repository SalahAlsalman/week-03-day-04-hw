package com.example.javaweek03day04.exceptions;

public class TeacherNotFoundException extends IllegalArgumentException{
    public TeacherNotFoundException(String s) {
        super(s);
    }
}
