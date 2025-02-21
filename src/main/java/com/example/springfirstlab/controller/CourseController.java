package com.example.springfirstlab.controller;

import com.example.springfirstlab.dto.CourseDTO;
import com.example.springfirstlab.dto.CreateCourseDTO;
import com.example.springfirstlab.service.impl.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CreateCourseDTO dto) {
        return ResponseEntity.ok(courseService.createCourse(dto));
    }
}
