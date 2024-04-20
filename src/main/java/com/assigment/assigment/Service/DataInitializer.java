package com.assigment.assigment.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.assigment.assigment.Models.Course;
import com.assigment.assigment.Repository.CourseRepository;
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;
    
    @Override
    public void run(String... args) throws Exception {
        Course course1 = new Course();
        course1.setTitle("Introduction to Java");
        course1.setDescription("Learn the basics of Java programming.");
        course1.setFeesInPounds("100£");

        Course course2 = new Course();
        course2.setTitle("Web Development with Spring Boot");
        course2.setDescription("Dive into web development with Spring Boot.");
        course2.setFeesInPounds("150£");

        Course course3 = new Course();
        course3.setTitle("Data Structures in Java");
        course3.setDescription("Explore data structures essential for complex Java applications.");
        course3.setFeesInPounds("120£");

        Course course4 = new Course();
        course4.setTitle("Machine Learning with Java");
        course4.setDescription("Learn how to implement ML algorithms in Java.");
        course4.setFeesInPounds("200£");

        Course course5 = new Course();
        course5.setTitle("Advanced Java Programming");
        course5.setDescription("Master advanced Java programming techniques.");
        course5.setFeesInPounds("180£");

        Course course6 = new Course();
        course6.setTitle("Android Development");
        course6.setDescription("Create engaging mobile apps using Java and Android Studio.");
        course6.setFeesInPounds("160£");

        Course course7 = new Course();
        course7.setTitle("Software Testing Fundamentals");
        course7.setDescription("Learn software testing techniques to ensure application reliability.");
        course7.setFeesInPounds("130£");

        Course course8 = new Course();
        course8.setTitle("Database Management Systems");
        course8.setDescription("Understand database concepts and management using SQL.");
        course8.setFeesInPounds("140£");

        Course course9 = new Course();
        course9.setTitle("Web Security Essentials");
        course9.setDescription("Identify and mitigate web security vulnerabilities.");
        course9.setFeesInPounds("175£");

        Course course10 = new Course();
        course10.setTitle("Cloud Computing with AWS");
        course10.setDescription("Explore cloud services and infrastructure on AWS.");
        course10.setFeesInPounds("210£");

        Course course11 = new Course();
        course11.setTitle("Front-End Development with React");
        course11.setDescription("Develop interactive web front-ends using React.");
        course11.setFeesInPounds("190£");

        Course course12 = new Course();
        course12.setTitle("DevOps Practices");
        course12.setDescription("Learn about CI/CD pipelines and monitoring in DevOps.");
        course12.setFeesInPounds("220£");

        Course course13 = new Course();
        course13.setTitle("Introduction to IoT");
        course13.setDescription("Get started with the basics of the Internet of Things.");
        course13.setFeesInPounds("150£");

        // Save all courses to the repository
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        courseRepository.save(course6);
        courseRepository.save(course7);
        courseRepository.save(course8);
        courseRepository.save(course9);
        courseRepository.save(course10);
        courseRepository.save(course11);
        courseRepository.save(course12);
        courseRepository.save(course13);
    }

}
