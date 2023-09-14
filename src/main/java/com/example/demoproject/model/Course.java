package com.example.demoproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String courseCode;
        private String courseTitle;
        private String status;
        private String grade;
        private int score;
        private int creditHours;

        @ManyToOne
        @JoinColumn(name = "student_id")
        private Student student;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCourseCode() {
                return courseCode;
        }

        public void setCourseCode(String courseCode) {
                this.courseCode = courseCode;
        }

        public String getCourseTitle() {
                return courseTitle;
        }

        public void setCourseTitle(String courseTitle) {
                this.courseTitle = courseTitle;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getGrade() {
                return grade;
        }

        public void setGrade(String grade) {
                this.grade = grade;
        }

        public int getScore() {
                return score;
        }

        public void setScore(int score) {
                this.score = score;
        }

        public int getCreditHours() {
                return creditHours;
        }

        public void setCreditHours(int creditHours) {
                this.creditHours = creditHours;
        }

        public Student getStudent() {
                return student;
        }

        public void setStudent(Student student) {
                this.student = student;
        }
}
