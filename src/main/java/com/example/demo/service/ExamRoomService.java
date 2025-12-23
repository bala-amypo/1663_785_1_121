package com.example.demo.service;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamRoomService {

    @Autowired
    private ExamRoomRepository repository;

    public ExamRoom save(ExamRoom room) {
        return repository.save(room);
    }

    public ExamRoom getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public List<ExamRoom> getAll() {
        return repository.findAll();
    }
}
