package com.example.demoproject.service;

import com.example.demoproject.model.Course;
import com.example.demoproject.model.Student;

import java.util.List;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Course createCourse(Long studentId, Course course);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    List<Course> getCoursesByStudentId(Long studentId);
    Student updateStudent(Long id, Student updatedStudent);
    Course updateCourse(Long courseId, Course updatedCourse);
    void deleteStudent(Long id);
    void deleteCourse(Long courseId);


    // New method to get a course by its ID
    Course getCourseById(Long courseId);
}
