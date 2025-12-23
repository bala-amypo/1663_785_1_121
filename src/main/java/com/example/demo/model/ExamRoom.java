package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ExamRoom {
@Id @GeneratedValue
private Long id;


@Column(unique = true)
private String roomNumber;
private Integer rows;
private Integer columns;
private Integer capacity;


@PrePersist @PreUpdate
public void ensureCapacityMatches() {
this.capacity = rows * columns;
}
}