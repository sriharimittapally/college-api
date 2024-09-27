// src/main/java/com/example/collegeapi/service/CourseService.java
package com.example.collegeapi.service;

import com.example.collegeapi.model.Course;
import com.example.collegeapi.model.CourseFee;
import com.example.collegeapi.repository.CourseFeeRepository;
import com.example.collegeapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseFeeRepository courseFeeRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getCoursesByCollegeId(Long collegeId) {
        return courseRepository.findByCollegeId(collegeId);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setName(courseDetails.getName());
            course.setDuration(courseDetails.getDuration());
            course.setAccommodationType(courseDetails.getAccommodationType());
            course.setAccommodationFee(courseDetails.getAccommodationFee());
            course.setCollege(courseDetails.getCollege());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public CourseFee saveCourseFee(CourseFee courseFee) {
        return courseFeeRepository.save(courseFee);
    }

    public CourseFee updateCourseFee(Long id, CourseFee courseFeeDetails) {
        CourseFee courseFee = courseFeeRepository.findById(id).orElse(null);
        if (courseFee != null) {
            courseFee.setFee(courseFeeDetails.getFee());
            courseFee.setCourse(courseFeeDetails.getCourse());
            return courseFeeRepository.save(courseFee);
        }
        return null;
    }

    public void deleteCourseFee(Long id) {
        courseFeeRepository.deleteById(id);
    }
}
