package com.fees.service;

import java.util.List;

import com.fees.dto.FeesDto;
import com.fees.entity.Fees;
import com.fees.entity.Receipt;

public interface FeeService {
	
	Fees createFeeAndReceipt(FeesDto feesDto);
	
	FeesDto getFeesDtoById(Long feesId);
	
	List<Fees> getAllFees();
	
	Receipt saveReceipt(Receipt receipt);
	
	Receipt getReceiptById(Long id);

	void deleteFee(Long id);

	void deleteReceipt(Long id);

	List<Receipt> getReceiptsByStudentId(Long studentId);
}
