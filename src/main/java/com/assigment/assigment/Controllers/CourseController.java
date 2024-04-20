package com.assigment.assigment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assigment.assigment.Models.Course;
import com.assigment.assigment.Models.Enrollment;
import com.assigment.assigment.Service.CourseService;
import com.assigment.assigment.Service.EnrollmentService;

@RestController
@RequestMapping("/api/courses") // This sets the base path for all requests handled by this controller.
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private EnrollmentService enrollmentService; // Add EnrollmentService.

    @GetMapping
    
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    
   

    @PostMapping("/enroll")
    public ResponseEntity<?> enrollInCourse(@RequestParam Long userId, @RequestParam Long courseId) {
        try {
            Enrollment enrollment = enrollmentService.enrollInCourse(userId, courseId);
            return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}
