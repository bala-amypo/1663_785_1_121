package com.example.demo.model;

import com.example.demo.exception.ApiException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "rollNumber"))
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String rollNumber;
    private String name;
    private String department;
    private Integer year;

    @PrePersist
    @PreUpdate
    void validateYear() {
        if (year < 1 || year > 5)
            throw new ApiException("year");
    }

    // getters and setters
}
