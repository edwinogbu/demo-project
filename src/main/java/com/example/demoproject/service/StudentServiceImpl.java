package com.example.demoproject.service;

import com.example.demoproject.model.Course;
import com.example.demoproject.model.Student;
import com.example.demoproject.repository.CourseRepository;
import com.example.demoproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Course createCourse(Long studentId, Course course) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            course.setStudent(student);
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return student.getCourses();
        }
        return null;
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            // Update student properties
            student.setFullName(updatedStudent.getFullName());
            student.setDateOfBirth(updatedStudent.getDateOfBirth());
            // Update other properties as needed
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public Course updateCourse(Long courseId, Course updatedCourse) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            // Update course properties
            course.setCourseCode(updatedCourse.getCourseCode());
            course.setCourseTitle(updatedCourse.getCourseTitle());
            // Update other properties as needed
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }
}
