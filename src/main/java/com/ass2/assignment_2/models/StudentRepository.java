package com.ass2.assignment_2.models; 

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
     List<Student> findByGPA(Float GPA);
     List<Student> findByName(String name);
}