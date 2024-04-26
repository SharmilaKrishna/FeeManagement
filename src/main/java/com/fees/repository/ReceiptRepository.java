package com.fees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fees.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

	
	List<Receipt> findByStudentId(Long studentId);

}
