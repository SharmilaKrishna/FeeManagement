package com.fees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fees.entity.ItemDetail;

@Repository
public interface ItemDetailRepository extends JpaRepository<ItemDetail, Long> {
	
	List<ItemDetail> findByReceiptReceiptId(Long receiptId);

}
