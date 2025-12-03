package com.example.student.repository;

import com.example.student.model.University;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {}

