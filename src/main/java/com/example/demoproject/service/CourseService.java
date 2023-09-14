package com.example.demoproject.service;

import com.example.demoproject.model.Course;

import java.util.List;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
//
//    List<Course> getAllCourses();
//    Course getCourseById(Long id);
//    List<Course> getCoursesBySemesterId(Long semesterId);
//    Course getCourseByCourseCode(String courseCode);
//    List<Course> getCoursesByStatus(String status);
//    Course saveCourse(Course course);
//    void deleteCourse(Long id);
}
