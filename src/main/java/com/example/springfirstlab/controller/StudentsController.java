package com.example.springfirstlab.controller;

import com.example.springfirstlab.dto.StudentDTO;
import com.example.springfirstlab.dto.CreateStudentDTO;
import com.example.springfirstlab.service.impl.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentsController {

    private final StudentService service;

    @GetMapping("/all")
    public List<StudentDTO> findAllStudent() {
        return service.findAllStudents();
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody CreateStudentDTO studentDTO) {
        return ResponseEntity.ok(service.createStudent(studentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.readStudent(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody CreateStudentDTO studentDTO) {
        return ResponseEntity.ok(service.updateStudent(id, studentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
