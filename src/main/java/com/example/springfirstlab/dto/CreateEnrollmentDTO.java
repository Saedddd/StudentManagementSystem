package com.example.springfirstlab.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEnrollmentDTO {
    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;
}
