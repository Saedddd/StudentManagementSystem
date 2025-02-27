package com.example.springfirstlab.service.impl;

import com.example.springfirstlab.dto.EnrollmentDTO;
import com.example.springfirstlab.dto.CreateEnrollmentDTO;
import com.example.springfirstlab.dto.UpdateEnrollmentDTO;
import com.example.springfirstlab.model.Enrollment;
import com.example.springfirstlab.model.Student;
import com.example.springfirstlab.model.Course;
import com.example.springfirstlab.repository.EnrollmentRepository;
import com.example.springfirstlab.repository.StudentRepository;
import com.example.springfirstlab.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(EnrollmentDTO::new)
                .collect(Collectors.toList());
    }

    public EnrollmentDTO getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        return new EnrollmentDTO(enrollment);
    }

    public EnrollmentDTO createEnrollment(CreateEnrollmentDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(dto.getEnrollmentDate());

        enrollment = enrollmentRepository.save(enrollment);
        return new EnrollmentDTO(enrollment);
    }

    public EnrollmentDTO updateEnrollment(Long id, UpdateEnrollmentDTO dto) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            enrollment.setStudent(student);
        }

        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));
            enrollment.setCourse(course);
        }

        if (dto.getEnrollmentDate() != null) {
            enrollment.setEnrollmentDate(dto.getEnrollmentDate());
        }

        enrollment = enrollmentRepository.save(enrollment);
        return new EnrollmentDTO(enrollment);
    }


    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
