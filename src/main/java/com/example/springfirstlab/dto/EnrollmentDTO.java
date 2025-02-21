package com.example.springfirstlab.dto;

import com.example.springfirstlab.model.Enrollment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;

    public EnrollmentDTO(Enrollment enrollment) {
        this.id = enrollment.getId();
        this.studentId = enrollment.getStudent().getId();
        this.courseId = enrollment.getCourse().getId();
        this.enrollmentDate = enrollment.getEnrollmentDate();
    }
}
