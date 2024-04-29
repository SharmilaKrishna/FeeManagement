package com.fees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fees.entity.Receipt;

public interface ReceiptRepository  extends JpaRepository<Receipt, Long> {

}
