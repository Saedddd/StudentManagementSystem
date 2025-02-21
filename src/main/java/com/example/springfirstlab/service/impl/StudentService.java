package com.example.springfirstlab.service.impl;

import com.example.springfirstlab.dto.StudentDTO;
import com.example.springfirstlab.dto.CreateStudentDTO;
import com.example.springfirstlab.model.Student;
import com.example.springfirstlab.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDTO> findAllStudents() {
        log.info("Fetching all students...");
        return studentRepository.findAll().stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    public StudentDTO createStudent(CreateStudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDob(studentDTO.getDob());
        student.setEmail(studentDTO.getEmail());

        student = studentRepository.save(student);
        return new StudentDTO(student);
    }

    public StudentDTO updateStudent(Long id, CreateStudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with ID " + id + " not found"));

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDob(studentDTO.getDob());
        student.setEmail(studentDTO.getEmail());

        student = studentRepository.save(student);
        return new StudentDTO(student);
    }

    public StudentDTO readStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Student with ID {} not found", id);
                    return new IllegalArgumentException("Student with ID " + id + " not found");
                });
        return new StudentDTO(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
        log.info("Deleting student with ID {}", id);
        studentRepository.deleteById(id);
    }
}
