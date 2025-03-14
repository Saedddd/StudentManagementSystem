//package com.example.springfirstlab.config;
//
//import com.example.springfirstlab.model.Student;
//import com.example.springfirstlab.repository.StudentRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//
//@Component
//@RequiredArgsConstructor
////public class DataInitializer implements CommandLineRunner {
////
////    private final StudentRepository studentRepository;
////    private final PasswordEncoder passwordEncoder;
////
////    @Override
////    public void run(String... args) {
////        if (studentRepository.findByEmail("student@example.com").isEmpty()) {
////            Student student = new Student();
////            student.setFirstName("Jn");
////            student.setLastName("Doe");
////            student.setDob(LocalDate.of(2000, 1, 1));
////            student.setEmail("student2@example.com");
////            student.setPassword(passwordEncoder.encode("password"));
////            studentRepository.save(student);
////        }
////    }
////}
//
