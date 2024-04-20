package com.assigment.assigment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.assigment.Models.Course;
import com.assigment.assigment.Models.Enrollment;
import com.assigment.assigment.Models.Student;
import com.assigment.assigment.Models.User;
import com.assigment.assigment.Repository.CourseRepository;
import com.assigment.assigment.Repository.EnrollmentRepository;
import com.assigment.assigment.Repository.StudentRepository;
import com.assigment.assigment.Repository.UserRepository;

@Service
public class EnrollmentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;
    

    @Autowired
    private CourseRepository courseRepository;
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    


    public Enrollment enrollInCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalStateException("Course not found"));

        Student student = studentRepository.findByUserId(user.getId())
                .orElseGet(() -> createStudent(user));

        if (enrollmentRepository.existsByStudentAndCourse(student, course)) {
            throw new IllegalStateException("Student is already enrolled in this course.");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    private Student createStudent(User user) {
        Student newStudent = new Student();
        newStudent.setUser(user);
        return studentRepository.save(newStudent);
    }
}