package com.example.collegeapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int duration;
    private String accommodationType;
    private double accommodationFee;

    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonBackReference
    private College college;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private CourseFee courseFee;

    // Getters and Setters
}