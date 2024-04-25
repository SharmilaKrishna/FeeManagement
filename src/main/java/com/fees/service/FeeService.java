package com.fees.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fees.entity.FeeRequest;
import com.fees.model.Receipt;
import com.fees.repository.ReceiptRepository;
import com.student.model.Student;

@Service
public class FeeService {
    
    @Autowired
    private ReceiptRepository receiptRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    @Value("${student.service.url}")
    private String studentServiceUrl;

    /**
     * Collects fee from a student.
     *
     * @param feeRequest the fee request containing student ID and amount
     * @return the receipt of the fee collection
     * @throws RuntimeException if the student is not found
     */
    public Receipt collectFee(FeeRequest feeRequest) {
        try {
            // Retrieve student information from student service
            Student student = restTemplate.getForObject(studentServiceUrl + feeRequest.getStudentId(), Student.class);
            
            // Check if student exists
            if (student == null) {
                throw new RuntimeException("Student not found with ID: " + feeRequest.getStudentId());
            }
            
            // Associate fee with student
            Receipt receipt = new Receipt();
            receipt.setStudentId(student.getId());
            receipt.setStudentName(student.getName()); 
            receipt.setAmount(feeRequest.getAmount());
            receipt.setCollectionDate(new Date());
            receipt.setCardNum(feeRequest.getCardNum());
            receipt.setCardType(feeRequest.getCardType());
            receipt.setReferenceId(feeRequest.getReferenceId());
            // Save receipt in repository
            return receiptRepository.save(receipt);
        } catch (RestClientException e) {
            // Handle RestClientException
            throw new RuntimeException("Error communicating with student service", e);
        }
    }

    /**
     * Retrieves all receipts for a given student ID.
     *
     * @param studentId the ID of the student
     * @return the list of receipts for the student
     */
    public List<Receipt> getReceiptsByStudentId(Long studentId) {
        return receiptRepository.findByStudentId(studentId);
    }

    /**
     * Retrieves all receipts.
     *
     * @return the list of all receipts
     */
    public List<Receipt> findAllReceipts() {
        return receiptRepository.findAll();
    }
}
