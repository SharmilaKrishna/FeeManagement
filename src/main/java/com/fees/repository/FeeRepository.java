package com.fees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fees.dto.FeesDto;
import com.fees.entity.Fees;

@Repository
public interface FeeRepository extends JpaRepository<Fees, Long> {
	
	@Query("SELECT new com.fees.dto.FeesDto(f.studentId, f.amount, f.paymentDate, f.status, r.studentName, r.referenceNumber, r.cardNumber, r.cardType, r.receiptId) " +
	           "FROM Fees f " +
	           "LEFT JOIN f.receipt r " +
	           "WHERE f.feesId = :feesId")
	    FeesDto findFeesDtoById(@Param("feesId") Long feesId);


	@Query("SELECT new com.fees.dto.FeesDto(f.studentId, f.amount, f.paymentDate, f.status, r.studentName, r.referenceNumber, r.cardNumber, r.cardType, r.receiptId) " +
	           "FROM Fees f " +
	           "LEFT JOIN f.receipt r " +
	           "WHERE f.studentId = :studentId")
	List<FeesDto> findFeesDtoByStudentId(@Param("studentId") Long studentId);
}
