package com.example.demo.service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ExamSessionService {
private final ExamSessionRepository repo;
private final StudentRepository studentRepo;


public ExamSessionService(ExamSessionRepository repo, StudentRepository studentRepo) {
this.repo = repo;
this.studentRepo = studentRepo;
}


public ExamSession createSession(ExamSession s) {
if (s.getExamDate().isBefore(LocalDate.now()))
throw new ApiException("past date");
if (s.getStudents().isEmpty())
throw new ApiException("at least 1 student");
return repo.save(s);
}
}