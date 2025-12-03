package com.example.student.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class University {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String location;

    @OneToMany(mappedBy = "university")
    
    private List<Student> students;
}
