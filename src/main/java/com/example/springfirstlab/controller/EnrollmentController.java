package com.example.springfirstlab.controller;


import com.example.springfirstlab.model.Enrollment;
import com.example.springfirstlab.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {
    private final EnrollmentRepository enrollmentRepository;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

}
