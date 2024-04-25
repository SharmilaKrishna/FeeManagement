package com.fees.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fees.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
