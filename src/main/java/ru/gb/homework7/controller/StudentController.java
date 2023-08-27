package ru.gb.homework7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hm7.model.Student;
import ru.gb.hm7.repository.StudentRepository;

import java.util.List;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/students")
            public String addStudent(Student student) {
            studentRepository.save(student);
            return "redirect:/students";
}

    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        model.addAttribute("student", student);
        return "student";
    }

    @PutMapping("/students/{id}")
    public String updateStudentById(@PathVariable Long id, Student student) {
        student.setId(id);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}