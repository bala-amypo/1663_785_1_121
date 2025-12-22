package com.example.demo.model;

import com.example.demo.exception.ApiException;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ExamSession {

    @Id
    @GeneratedValue
    private Long id;

    private String courseCode;
    private LocalDate examDate;
    private String examTime;

    @ManyToMany
    private List<Student> students;

    @PrePersist
    void validate() {
        if (examDate.isBefore(LocalDate.now()))
            throw new ApiException("past");
        if (students == null || students.isEmpty())
            throw new ApiException("at least 1 student");
    }

    // getters and setters
}
