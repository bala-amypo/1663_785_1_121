package com.example.demo.service;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamRoomService {

    private final ExamRoomRepository repo;

    public ExamRoomService(ExamRoomRepository repo) {
        this.repo = repo;
    }

    public ExamRoom createRoom(ExamRoom room) {
        return repo.save(room);
    }

    public ExamRoom getRoom(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public List<ExamRoom> getAllRooms() {
        return repo.findAll();
    }
}






// package com.example.demo.service;

// import com.example.demo.exception.ApiException;
// import com.example.demo.model.ExamRoom;
// import com.example.demo.repository.ExamRoomRepository;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class ExamRoomService {

//     private final ExamRoomRepository repo;

//     public ExamRoomService(ExamRoomRepository repo) {
//         this.repo = repo;
//     }

//     public ExamRoom addRoom(ExamRoom room) {
//         if (repo.findByRoomNumber(room.getRoomNumber()) != null)
//             throw new ApiException("exists");
//         return repo.save(room);
//     }

//     public List<ExamRoom> getAllRooms() {
//         return repo.findAll();
//     }
// }
