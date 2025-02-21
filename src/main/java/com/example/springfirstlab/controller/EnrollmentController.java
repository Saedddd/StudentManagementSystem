package com.example.springfirstlab.controller;

import com.example.springfirstlab.dto.EnrollmentDTO;
import com.example.springfirstlab.dto.CreateEnrollmentDTO;
import com.example.springfirstlab.service.impl.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> createEnrollment(@RequestBody CreateEnrollmentDTO dto) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> updateEnrollment(@PathVariable Long id, @RequestBody CreateEnrollmentDTO dto) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}
