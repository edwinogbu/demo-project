package com.example.demoproject.contoller;


import com.example.demoproject.model.Course;
import com.example.demoproject.model.Student;
import com.example.demoproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PostMapping("/{studentId}/courses")
    public ResponseEntity<Course> createCourse(@PathVariable Long studentId, @RequestBody Course course) {
        Course createdCourse = studentService.createCourse(studentId, course);
        if (createdCourse != null) {
            return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable Long studentId) {
        List<Course> courses = studentService.getCoursesByStudentId(studentId);
        if (courses != null) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(id, updatedStudent);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/courses/update/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course updatedCourse) {
        Course course = studentService.updateCourse(courseId, updatedCourse);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/courses/delete/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        studentService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{studentId}/courses/{courseId}/calculateGP")
    public ResponseEntity<Double> calculateGPCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Course course = studentService.getCourseById(courseId);
        if (course != null) {
            String grade = course.getGrade();
            double gp = calculateGP(grade);
            return new ResponseEntity<>(gp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{studentId}/calculateGPA")
    public ResponseEntity<Double> calculateGPA(@PathVariable Long studentId) {
        List<Course> courses = studentService.getCoursesByStudentId(studentId);
        if (courses != null && !courses.isEmpty()) {
            double totalCredits = 0.0;
            double totalGPA = 0.0;
            for (Course course : courses) {
                double courseGPA = calculateGP(course.getGrade());
                int creditHours = course.getCreditHours();
                totalGPA += (courseGPA * creditHours);
                totalCredits += creditHours;
            }
            double gpa = totalGPA / totalCredits;
            return new ResponseEntity<>(gpa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{studentId}/calculateCGPA")
    public ResponseEntity<Double> calculateCGPA(@PathVariable Long studentId) {
        List<Course> courses = studentService.getCoursesByStudentId(studentId);
        if (courses != null && !courses.isEmpty()) {
            double totalCredits = 0.0;
            double totalGPA = 0.0;
            for (Course course : courses) {
                double courseGPA = calculateGP(course.getGrade());
                int creditHours = course.getCreditHours();
                totalGPA += (courseGPA * creditHours);
                totalCredits += creditHours;
            }
            double cgpa = totalGPA / totalCredits;
            return new ResponseEntity<>(cgpa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{studentId}/calculateWGPA")
    public ResponseEntity<Double> calculateWGPA(@PathVariable Long studentId) {
        List<Course> courses = studentService.getCoursesByStudentId(studentId);
        if (courses != null && !courses.isEmpty()) {
            double totalPassedCredits = 0.0;
            double totalWGPA = 0.0;
            for (Course course : courses) {
                if (course.getStatus().equalsIgnoreCase("Pass")) {
                    double courseGPA = calculateGP(course.getGrade());
                    int creditHours = course.getCreditHours();
                    totalWGPA += (courseGPA * creditHours);
                    totalPassedCredits += creditHours;
                }
            }
            if (totalPassedCredits > 0) {
                double wgpa = totalWGPA / totalPassedCredits;
                return new ResponseEntity<>(wgpa, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    private double calculateGP(String grade) {
        switch (grade) {
            case "A+":
                return 5.0;
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0; // Default to 0.0 for unrecognized grades.
        }
    }


}
