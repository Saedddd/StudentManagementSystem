package com.example.springfirstlab.service.impl;

import com.example.springfirstlab.dto.CourseDTO;
import com.example.springfirstlab.dto.CreateCourseDTO;
import com.example.springfirstlab.model.Course;
import com.example.springfirstlab.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    public CourseDTO createCourse(CreateCourseDTO dto) {
        Course course = new Course();
        course.setName(dto.getName());

        course = courseRepository.save(course);
        return new CourseDTO(course);
    }
}
