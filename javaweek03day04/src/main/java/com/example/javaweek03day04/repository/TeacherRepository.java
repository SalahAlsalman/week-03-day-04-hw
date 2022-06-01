package com.example.javaweek03day04.repository;

import com.example.javaweek03day04.model.Student;
import com.example.javaweek03day04.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
