package com.example.demo.service;

import com.example.demo.model.SeatingPlan;
import com.example.demo.repository.SeatingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingPlanService {

    @Autowired
    private SeatingPlanRepository repository;

    public SeatingPlan save(SeatingPlan plan) {
        return repository.save(plan);
    }

    public SeatingPlan getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
    }

    public List<SeatingPlan> getAll() {
        return repository.findAll();
    }
}
