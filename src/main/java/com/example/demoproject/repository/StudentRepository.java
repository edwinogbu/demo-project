package com.example.demoproject.repository;

import com.example.demoproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    // Find students by department
//    List<Student> findByDepartment(String department);
//
//    // Find students by faculty
//    List<Student> findByFaculty(String faculty);
//
//    // Find students by entry year
//    List<Student> findByEntryYear(String entryYear);
//
//    // Find students by graduation year
//    List<Student> findByGraduationYear(String graduationYear);
//
//    // Find students by registration number
//    Student findByRegistrationNumber(String registrationNumber);

    // Add more custom query methods as needed
}
