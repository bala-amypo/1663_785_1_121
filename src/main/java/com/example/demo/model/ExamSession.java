package com.example.demo.model;

import com.example.demo.exception.ApiException;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
public class ExamSession {
@Id @GeneratedValue
private Long id;
private String courseCode;
private LocalDate examDate;
private String examTime;


@ManyToMany
private List<Student> students;
}