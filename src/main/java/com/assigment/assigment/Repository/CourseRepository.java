package com.assigment.assigment.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.assigment.Models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
