package com.example.demo.controller;

import com.example.demo.model.ExamRoom;
import com.example.demo.service.ExamRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class ExamRoomController {

    private final ExamRoomService service;

    public ExamRoomController(ExamRoomService service) {
        this.service = service;
    }

    @PostMapping
    public ExamRoom createRoom(@RequestBody ExamRoom room) {
        return service.createRoom(room);
    }

    @GetMapping("/{id}")
    public ExamRoom getRoom(@PathVariable Long id) {
        return service.getRoom(id);
    }

    @GetMapping
    public List<ExamRoom> getAllRooms() {
        return service.getAllRooms();
    }
}




// package com.example.demo.controller;

// import com.example.demo.model.ExamRoom;
// import com.example.demo.service.ExamRoomService;
// import io.swagger.v3.oas.annotations.*;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/rooms")

// public class ExamRoomController {

//     private final ExamRoomService service;

//     public ExamRoomController(ExamRoomService service) {
//         this.service = service;
//     }

//     @PostMapping
//     @Operation(summary = "Add exam room")
//     public ExamRoom add(@RequestBody ExamRoom r) {
//         return service.addRoom(r);
//     }

//     @GetMapping
//     @Operation(summary = "List rooms")
//     public List<ExamRoom> list() {
//         return service.getAllRooms();
//     }
// }
