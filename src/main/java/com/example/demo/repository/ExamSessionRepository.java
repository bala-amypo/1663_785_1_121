package com.example.demo.repository;

import com.example.demo.model.ExamSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface ExamSessionRepository extends JpaRepository<ExamSession, Long> {
    ExamSession findByExamDate(LocalDate date);
}
