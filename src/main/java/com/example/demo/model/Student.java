package com.example.demo.model;

import com.example.demo.exception.ApiException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String rollNumber;
    private int year;

    // REQUIRED getters & setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public int getYear() { return year; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public void setYear(int year) { this.year = year; }
}
