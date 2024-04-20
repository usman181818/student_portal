package com.assigment.assigment.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assigment.assigment.Models.Student;
import com.assigment.assigment.Service.StudentProfileUpdateDTO;
import com.assigment.assigment.Service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentProfile(@PathVariable Long id, @RequestBody StudentProfileUpdateDTO updateDTO) {
        Student updatedStudent = studentService.updateStudentProfile(id, updateDTO);
        return ResponseEntity.ok(updatedStudent);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentProfile(@PathVariable Long id) {
        Student student = studentService.getStudentProfile(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}/graduation-eligibility")
    public ResponseEntity<?> checkGraduationEligibility(@PathVariable Long id) {
        boolean isEligible = studentService.checkGraduationEligibility(id);
        if (isEligible) {
            return ResponseEntity.ok(Map.of("eligible", true, "message", "Student is eligible to graduate."));
        } else {
            return ResponseEntity.ok(Map.of("eligible", false, "message", "Student has outstanding invoices and is not eligible to graduate."));
        }
    }
}