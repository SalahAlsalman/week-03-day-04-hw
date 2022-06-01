package com.example.javaweek03day04.exceptions;

public class StudentNotFoundException extends IllegalArgumentException{
    public StudentNotFoundException(String s) {
        super(s);
    }
}
