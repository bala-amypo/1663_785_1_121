package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
public class SeatingPlan {
@Id @GeneratedValue
private Long id;


@ManyToOne
private ExamSession examSession;


@ManyToOne
private ExamRoom room;


@Lob
private String arrangementJson;


private LocalDateTime generatedAt;


@PrePersist
public void onCreate() {
generatedAt = LocalDateTime.now();
}
}