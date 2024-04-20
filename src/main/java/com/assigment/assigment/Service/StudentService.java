package com.assigment.assigment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.assigment.Models.Invoice;
import com.assigment.assigment.Models.Student;
import com.assigment.assigment.Repository.InvoiceRepository;
import com.assigment.assigment.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Method to retrieve a student's profile by ID
    public Student getStudentProfile(Long id) {
        // This will fetch the student from the database if they exist
        return studentRepository.findById(id).orElse(null);
    }


    public Student updateStudentProfile(Long studentId, StudentProfileUpdateDTO updateDTO) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstName(updateDTO.getFirstName());
        student.setLastName(updateDTO.getLastName());
        return studentRepository.save(student);
    }
    @Autowired
    private InvoiceRepository invoiceRepository; // Autowired repository

    public boolean checkGraduationEligibility(Long studentId) {
        // Use the autowired instance to call the method
        List<Invoice> outstandingInvoices = invoiceRepository.findByStudentIdAndStatus(studentId, "OUTSTANDING");
        return outstandingInvoices.isEmpty();
    }

}
