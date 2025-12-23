package com.example.demo.controller;

import com.example.demo.model.ExamSession;
import com.example.demo.service.ExamSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class ExamSessionController {

    @Autowired
    private ExamSessionService service;

    @PostMapping
    public ExamSession create(@RequestBody ExamSession session) {
        return service.save(session);   // ✅ was createSession
    }

    @GetMapping("/{id}")
    public ExamSession getById(@PathVariable Long id) {
        return service.getById(id);     // ✅ was getSession
    }

    @GetMapping
    public List<ExamSession> getAll() {
        return service.getAll();
    }
}
