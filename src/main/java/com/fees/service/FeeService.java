package com.fees.service;

import java.util.List;

import com.fees.dto.FeesDto;
import com.fees.entity.Fees;
import com.fees.entity.ItemDetail;
import com.fees.entity.Receipt;

public interface FeeService {
	
	Fees createFeeAndReceipt(FeesDto feesDto);
	
	FeesDto getFeesDtoById(Long feesId);
	
	List<Fees> getAllFees();
	
	Receipt saveReceipt(Receipt receipt);
	
	Receipt getReceiptById(Long id);
	
	ItemDetail saveItemDetail(ItemDetail itemDetail);
	
	ItemDetail getItemDetailById(Long id);

	List<ItemDetail> getAllItemDetails();

	void deleteFee(Long id);

	void deleteReceipt(Long id);

	void deleteItemDetail(Long id);

	List<Receipt> getReceiptsByStudentId(Long studentId);
}
