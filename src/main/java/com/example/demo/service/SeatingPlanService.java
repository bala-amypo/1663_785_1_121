package com.example.demo.service;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingPlanService {

    private final ExamRoomRepository roomRepo;

    public SeatingPlanService(ExamRoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    public List<ExamRoom> generateSeatingPlan(int requiredCapacity) {
        return roomRepo.findByCapacityGreaterThanEqual(requiredCapacity);
    }
}
