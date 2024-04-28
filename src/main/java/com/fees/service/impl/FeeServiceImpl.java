package com.fees.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.fees.dto.FeesDto;
import com.fees.entity.Fees;
import com.fees.entity.Receipt;
import com.fees.entity.Student;
import com.fees.repository.FeeRepository;
import com.fees.repository.ReceiptRepository;
import com.fees.service.FeeService;

@Service	
public class FeeServiceImpl implements FeeService {
    private static final Logger logger = LoggerFactory.getLogger(FeeServiceImpl.class);


	@Autowired
	private FeeRepository feeRepository;

	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired 
	private RestTemplate restTemplate;
	
	@Value("${student.service.url}")
	private String studentServiceUrl;
	
	@Transactional
	@Override
	public Fees createFeeAndReceipt(FeesDto feesDto) {
		// Check if feesDto is null
        logger.info("Creating fee and receipt for FeesDto: {}", feesDto);
		if (ObjectUtils.isEmpty(feesDto)) {
	        throw new IllegalArgumentException("Provided FeesDto cannot be null");
	    }
		
		// Fetch student information from student service
		Student student = restTemplate.getForObject(studentServiceUrl + feesDto.getStudentId(), Student.class);
		
        // Check if student exists
		if (ObjectUtils.isEmpty(student)) {
            logger.error("Student not found with ID: {}", feesDto.getStudentId());
			throw new RuntimeException("Student not found with ID: " + feesDto.getStudentId());
		}
        // Create fees entity
	    Fees fee = new Fees(feesDto.getStudentId(), feesDto.getAmount(), feesDto.getPaymentDate(), feesDto.getStatus());
	    fee = feeRepository.save(fee);
       
	    // Check if fee or card details are null
	    if (fee == null || feesDto.getCardNumber() == null || feesDto.getCardType() == null) {
            logger.error("Card details must not be null");
	        throw new IllegalArgumentException("Card details must not be null");
	    }
	    Receipt receipt = new Receipt(fee, student.getName(), feesDto.getReferenceNumber(),
	                                  feesDto.getCardNumber(), feesDto.getCardType());
	    receipt = receiptRepository.save(receipt);
        logger.info("Receipt created: {}", receipt);

	   return fee;
	}
	

	

	@Override
	public Receipt saveReceipt(Receipt receipt) {
		return receiptRepository.save(receipt);
	}

	@Override
	public List<Fees> getAllFees() {
		return feeRepository.findAll();
	}


	@Override
	public Receipt getReceiptById(Long id) {
		return receiptRepository.findById(id).orElse(null);
	}


	@Override
	public void deleteFee(Long id) {
		feeRepository.deleteById(id);
	}

	@Override
	public void deleteReceipt(Long id) {
		receiptRepository.deleteById(id);
	}

	 @Override
	public List<Receipt> getReceiptsByStudentId(Long studentId) {
		return null;
	}

	@Override
	public FeesDto getFeesDtoById(Long feesId) {
		// TODO Auto-generated method stub
		return null;
	}
}
