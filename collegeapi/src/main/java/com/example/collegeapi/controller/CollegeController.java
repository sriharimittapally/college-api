// src/main/java/com/example/collegeapi/controller/CollegeController.java
package com.example.collegeapi.controller;

import com.example.collegeapi.model.College;
import com.example.collegeapi.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/colleges")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }
}
