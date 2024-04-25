package com.feeManagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feeManagement.model.FeeRequest;
import com.feeManagement.model.Receipt;
import com.feeManagement.repository.ReceiptDetailsRepository;
import com.student.model.Student;

@Service
public class FeeService {

	@Autowired
    private ReceiptDetailsRepository receiptRepository;
	
	 @Autowired
	 private RestTemplate restTemplate;
	 
	  @Value("${student.service.url}")
	  private String studentServiceUrl;

    public Receipt collectFee(FeeRequest feeRequest) {
    	Student student = restTemplate.getForObject(studentServiceUrl + feeRequest.getStudentId(), Student.class);

        if (student == null) {
            throw new RuntimeException("Student not found with ID: " + feeRequest.getStudentId());
        }

        // Associate fee with student
        Receipt receipt = new Receipt();
        receipt.setStudentId(student.getId());
        receipt.setStudentName(student.getName()); 
        receipt.setAmount(feeRequest.getAmount());
        receipt.setCollectionDate(new Date());
        
        
        return receiptRepository.save(receipt);
    }
    

    public List<Receipt> getReceiptsByStudentId(Long studentId) {
        return receiptRepository.findByStudentId(studentId);
    }


	public List<Receipt> findAllReceipts() {
        return receiptRepository.findAll();

	}
}
