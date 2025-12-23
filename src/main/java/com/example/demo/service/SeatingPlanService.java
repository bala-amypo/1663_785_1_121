package com.example.demo.service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatingPlanService {
private final ExamSessionRepository sessionRepo;
private final SeatingPlanRepository planRepo;
private final ExamRoomRepository roomRepo;


public SeatingPlanService(ExamSessionRepository s, SeatingPlanRepository p, ExamRoomRepository r) {
this.sessionRepo = s;
this.planRepo = p;
this.roomRepo = r;
}


public SeatingPlan generatePlan(Long sessionId) {
ExamSession session = sessionRepo.findById(sessionId)
.orElseThrow(() -> new ApiException("session not found"));


int required = session.getStudents().size();
List<ExamRoom> rooms = roomRepo.findByCapacityGreaterThanEqual(required);
if (rooms.isEmpty()) throw new ApiException("no room");


SeatingPlan plan = new SeatingPlan();
plan.setExamSession(session);
plan.setRoom(rooms.get(0));
plan.setArrangementJson("{ 'status':'generated' }");
return planRepo.save(plan);
}
}