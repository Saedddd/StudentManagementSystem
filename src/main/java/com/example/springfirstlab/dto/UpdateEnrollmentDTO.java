package com.example.springfirstlab.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateEnrollmentDTO {
    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;
}

