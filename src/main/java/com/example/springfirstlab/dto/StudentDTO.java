package com.example.springfirstlab.dto;


import com.example.springfirstlab.model.Student;
import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.dob = student.getDob();
        this.email = student.getEmail();
    }
}

