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

    // ⚠️ Constructor order MUST match tests
    public SeatingPlanServiceImpl(
            ExamSessionRepository sessionRepo,
            SeatingPlanRepository planRepo,
            ExamRoomRepository roomRepo
    ) {
        this.sessionRepo = sessionRepo;
        this.planRepo = planRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public SeatingPlan generatePlan(Long sessionId) {

        ExamSession session = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));

        int studentCount = session.getStudents().size();

        List<ExamRoom> rooms = roomRepo.findAll();
        if (rooms == null || rooms.isEmpty()) {
            throw new ApiException("no room");
        }

        // ✅ pick FIRST room that fits capacity
        ExamRoom selectedRoom = null;
        for (ExamRoom room : rooms) {
            if (room.getCapacity() != null && room.getCapacity() >= studentCount) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            throw new ApiException("no room");
        }

        // ✅ generate seating JSON
        Map<String, Object> arrangement = new LinkedHashMap<>();
        int seat = 1;
        for (Student s : session.getStudents()) {
            arrangement.put("Seat-" + seat++, s.getRollNumber());
        }

        try {
            String json = new ObjectMapper().writeValueAsString(arrangement);

            SeatingPlan plan = SeatingPlan.builder()
                    .examSession(session)
                    .room(selectedRoom)
                    .arrangementJson(json)
                    .build();

            return planRepo.save(plan);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SeatingPlan getPlan(Long id) {
        return planRepo.findById(id)
                .orElseThrow(() -> new ApiException("plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return planRepo.findByExamSessionId(sessionId);
    }
}
