package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
public class SeatingPlan {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ExamSession examSession;

    @ManyToOne
    private ExamRoom room;

    @Column(columnDefinition = "TEXT")
    private String arrangementJson;

    public Long getId() { return id; }
    public ExamSession getExamSession() { return examSession; }
    public ExamRoom getRoom() { return room; }
    public String getArrangementJson() { return arrangementJson; }

    public void setExamSession(ExamSession examSession) {
        this.examSession = examSession;
    }

    public void setRoom(ExamRoom room) {
        this.room = room;
    }

    public void setArrangementJson(String arrangementJson) {
        this.arrangementJson = arrangementJson;
    }
}
