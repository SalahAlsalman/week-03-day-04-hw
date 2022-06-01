package com.example.javaweek03day04.exceptions;

public class ClassroomNotFoundException extends IllegalArgumentException{
    public ClassroomNotFoundException(String s) {
        super(s);
    }
}
