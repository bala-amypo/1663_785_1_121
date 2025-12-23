package com.example.demo.model;

import com.example.demo.exception.ApiException;
import jakarta.persistence.*;
// import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;



@Entity
public class ExamSession {

    @Id
    @GeneratedValue
    private Long id;

    private String subject;

    private LocalDate examDate;

    @ManyToMany
    private List<Student> students;

    // getters & setters
    public Long getId() { return id; }
    public String getSubject() { return subject; }
    public LocalDate getExamDate() { return examDate; }
    public List<Student> getStudents() { return students; }

    public void setId(Long id) { this.id = id; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setExamDate(LocalDate examDate) { this.examDate = examDate; }
    public void setStudents(List<Student> students) { this.students = students; }
}
