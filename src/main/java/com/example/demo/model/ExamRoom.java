package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "roomNumber"))
public class ExamRoom {

    @Id
    @GeneratedValue
    private Long id;

    private String roomNumber;
    private Integer capacity;
    private Integer rows;
    private Integer columns;

    @PrePersist
    @PreUpdate
    void ensureCapacityMatches() {
        capacity = rows * columns;
    }

    // getters and setters
}
