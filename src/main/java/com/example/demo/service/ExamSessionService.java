package com.example.demo.service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ExamSessionService {

    @Autowired
    private ExamSessionRepository repository;

    public ExamSession save(ExamSession s) {
        return repository.save(s);
    }

    public ExamSession getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    public List<ExamSession> getAll() {
        return repository.findAll();
    }
}
