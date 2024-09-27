// src/main/java/com/example/collegeapi/controller/CourseController.java
package com.example.collegeapi.controller;

import com.example.collegeapi.model.Course;
import com.example.collegeapi.model.CourseFee;
import com.example.collegeapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/college/{collegeId}")
    public List<Course> getCoursesByCollegeId(@PathVariable Long collegeId) {
        return courseService.getCoursesByCollegeId(collegeId);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PostMapping("/fees")
    public CourseFee createCourseFee(@RequestBody CourseFee courseFee) {
        return courseService.saveCourseFee(courseFee);
    }

    @PutMapping("/fees/{id}")
    public CourseFee updateCourseFee(@PathVariable Long id, @RequestBody CourseFee courseFeeDetails) {
        return courseService.updateCourseFee(id, courseFeeDetails);
    }

    @DeleteMapping("/fees/{id}")
    public void deleteCourseFee(@PathVariable Long id) {
        courseService.deleteCourseFee(id);
    }
}
