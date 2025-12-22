package com.example.demo.controller;

import com.example.demo.model.ExamSession;
import com.example.demo.service.ExamSessionService;
import io.swagger.v3.oas.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
// @Tag(name = "Exam Sessions")
public class ExamSessionController {

    private final ExamSessionService service;

    public ExamSessionController(ExamSessionService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create exam session")
    public ExamSession create(@RequestBody ExamSession s) {
        return service.createSession(s);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get exam session")
    public ExamSession get(@PathVariable Long id) {
        return service.getSession(id);
    }
}
