package com.example.springfirstlab.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateStudentDTO {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
}
