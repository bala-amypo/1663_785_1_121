package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SeatingPlanService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository sessionRepo;
    private final SeatingPlanRepository planRepo;
    private final ExamRoomRepository roomRepo;

    public SeatingPlanServiceImpl(ExamSessionRepository s, SeatingPlanRepository p, ExamRoomRepository r) {
        this.sessionRepo = s;
        this.planRepo = p;
        this.roomRepo = r;
    }

    public SeatingPlan generatePlan(Long sessionId) {
        ExamSession session = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));

        List<ExamRoom> rooms = roomRepo.findAll();
        if (rooms.isEmpty())
            throw new ApiException("no room");

        ExamRoom room = rooms.get(0);

        Map<String, String> map = new HashMap<>();
        session.getStudents().forEach(s -> map.put(s.getRollNumber(), room.getRoomNumber()));

        try {
            String json = new ObjectMapper().writeValueAsString(map);
            SeatingPlan plan = SeatingPlan.builder()
                    .examSession(session)
                    .room(room)
                    .arrangementJson(json)
                    .build();
            return planRepo.save(plan);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SeatingPlan getPlan(Long id) {
        return planRepo.findById(id)
                .orElseThrow(() -> new ApiException("plan not found"));
    }

    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return planRepo.findByExamSessionId(sessionId);
    }
}
