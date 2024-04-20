package com.assigment.assigment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.assigment.Models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByStudentIdAndStatus(Long studentId, String status);
}
