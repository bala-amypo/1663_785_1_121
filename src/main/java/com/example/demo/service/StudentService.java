package com.example.demo.service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
private final StudentRepository repo;


public StudentService(StudentRepository repo) {
this.repo = repo;
}


public Student addStudent(Student s) {
if (s.getYear() < 1 || s.getYear() > 5)
throw new ApiException("invalid year");


if (repo.findByRollNumber(s.getRollNumber()) != null)
throw new ApiException("roll number exists");


return repo.save(s);
}
}