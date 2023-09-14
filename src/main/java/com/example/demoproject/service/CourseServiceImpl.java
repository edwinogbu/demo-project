package com.example.demoproject.service;

import com.example.demoproject.model.Course;
import com.example.demoproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }


//    private final CourseRepository courseRepository;
//
//    @Autowired
//    public CourseServiceImpl(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }
//
//    @Override
//    public List<Course> getAllCourses() {
//        return courseRepository.findAll();
//    }
//
//    @Override
//    public Course getCourseById(Long id) {
//        return courseRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Course> getCoursesBySemesterId(Long semesterId) {
//        return courseRepository.findBySemesterId(semesterId);
//    }
//
//    @Override
//    public Course getCourseByCourseCode(String courseCode) {
//        return courseRepository.findByCourseCode(courseCode);
//    }
//
//    @Override
//    public List<Course> getCoursesByStatus(String status) {
//        return courseRepository.findByStatus(status);
//    }
//
//    @Override
//    public Course saveCourse(Course course) {
//        return courseRepository.save(course);
//    }
//
//    @Override
//    public void deleteCourse(Long id) {
//        courseRepository.deleteById(id);
//    }
}
