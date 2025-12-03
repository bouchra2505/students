public package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

  @GetMapping("/searchByUniversityID")
    public List<Student> getStudentsByUniversityId(@RequestParam Long universityId) {
        return studentRepository.findByUniversityId(universityId);
    }

    @GetMapping("/searchByUniversityName")
    public List<Student> getStudentsByUniversityName(@RequestParam String name) {
        return studentRepository.findByUniversity_Name(name);
    }

    @GetMapping("/search")
public List<Student> searchStudents(@RequestParam String name) {
    return studentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
}


    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updated) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstName(updated.getFirstName());
            student.setLastName(updated.getLastName());
            student.setEmail(updated.getEmail());
            student.setUniversity(updated.getUniversity());
            return studentRepository.save(student);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}

 StudentController {
    
}
