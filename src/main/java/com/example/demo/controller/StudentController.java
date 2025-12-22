package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name = "Students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Add student")
    public Student add(@RequestBody Student s) {
        return service.addStudent(s);
    }

    @GetMapping
    @Operation(summary = "List students")
    public List<Student> list() {
        return service.getAllStudents();
    }
}
