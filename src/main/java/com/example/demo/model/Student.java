package com.example.demo.model;

import com.example.demo.exception.ApiException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
public class Student {
@Id @GeneratedValue
private Long id;


@Column(unique = true)
private String rollNumber;
private String name;
private String department;
private Integer year;
}