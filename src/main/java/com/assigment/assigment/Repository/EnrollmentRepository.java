package com.assigment.assigment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.assigment.Models.Course;
import com.assigment.assigment.Models.Enrollment;
import com.assigment.assigment.Models.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	 boolean existsByStudentAndCourse(Student student, Course course);
	
}
