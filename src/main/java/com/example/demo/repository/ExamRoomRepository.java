package com.example.demo.repository;

import com.example.demo.model.ExamRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRoomRepository extends JpaRepository<ExamRoom, Long> {
}






// package com.example.demo.repository;

// import com.example.demo.model.ExamRoom;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface ExamRoomRepository extends JpaRepository<ExamRoom, Long> {
//     ExamRoom findByRoomNumber(String roomNumber);
//     List<ExamRoom> findByCapacityGreaterThanEqual(Integer capacity);
// }
