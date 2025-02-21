package com.example.springfirstlab.service.impl;

import com.example.springfirstlab.model.Enrollment;
import com.example.springfirstlab.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
