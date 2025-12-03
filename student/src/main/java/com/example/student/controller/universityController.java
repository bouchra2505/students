package com.example.student.controller;

import com.example.student.model.University;
import com.example.student.repository.UniversityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class universityController {

    private final UniversityRepository universityRepository;

    public universityController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @GetMapping
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    @PostMapping
    public University addUniversity(@RequestBody University university) {
        return universityRepository.save(university);
    }
}
