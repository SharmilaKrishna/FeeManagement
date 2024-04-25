package com.feeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feeManagement.model.Receipt;

@Repository
public interface ReceiptDetailsRepository extends JpaRepository<Receipt, Long> {
    List<Receipt> findByStudentId(Long studentId);
    
    @Query("SELECT SUM(r.amount) FROM Receipt r WHERE r.cardType = :cardType")
    double calculateTotalFeesByCardType(@Param("cardType") String cardType);

}