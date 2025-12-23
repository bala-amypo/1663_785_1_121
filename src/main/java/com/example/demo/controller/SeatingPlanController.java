package com.example.demo.controller;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seating-plans")
public class SeatingPlanController {

    @Autowired
    private SeatingPlanService service;

    @PostMapping
    public SeatingPlan create(@RequestBody SeatingPlan plan) {
        return service.save(plan);   // ✅ was generatePlan
    }

    @GetMapping("/{id}")
    public SeatingPlan getById(@PathVariable Long id) {
        return service.getById(id);  // ✅ was getPlan
    }

    @GetMapping
    public List<SeatingPlan> getAll() {
        return service.getAll();     // ✅ was getPlansBySession
    }
}
