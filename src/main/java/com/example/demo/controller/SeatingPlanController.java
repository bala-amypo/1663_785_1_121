package com.example.demo.controller;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@Tag(name = "Seating Plan Controller")
public class SeatingPlanController {

    private final SeatingPlanService service;

    public SeatingPlanController(SeatingPlanService service) {
        this.service = service;
    }

    @PostMapping("/generate/{sessionId}")
    @Operation(summary = "Generate seating plan")
    public SeatingPlan generatePlan(@PathVariable Long sessionId) {
        return service.generatePlan(sessionId);
    }

    @GetMapping("/{planId}")
    @Operation(summary = "Get seating plan by ID")
    public SeatingPlan getPlan(@PathVariable Long planId) {
        return service.getPlan(planId);
    }

    @GetMapping("/session/{sessionId}")
    @Operation(summary = "Get seating plans by session")
    public List<SeatingPlan> getPlansBySession(@PathVariable Long sessionId) {
        return service.getPlansBySession(sessionId);
    }
}
