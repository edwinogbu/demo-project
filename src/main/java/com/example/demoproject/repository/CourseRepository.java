package com.example.demoproject.repository;

import com.example.demoproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Find courses by semester ID
//    List<Course> findBySemesterId(Long semesterId);
//
//    // Find courses by course code
//    Course findByCourseCode(String courseCode);
//
//    // Find courses by status (Pass/Fail)
//    List<Course> findByStatus(String status);

    // Add more custom query methods as needed
}
