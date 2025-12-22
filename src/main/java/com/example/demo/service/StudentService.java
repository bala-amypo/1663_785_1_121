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
        if (repo.findByRollNumber(s.getRollNumber()) != null)
            throw new ApiException("exists");
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
