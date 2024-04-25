package com.fees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fees.model.FeeRequest;
import com.fees.model.Receipt;

@Service
public class FeeService {

	/*
	 * @Autowired private ReceiptRepository receiptRepository;
	 */
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	 
	  @Value("${student.service.url}")
	  private String studentServiceUrl;

	  public Receipt collectFee(FeeRequest feeRequest) {
//    	Student student = restTemplate.getForObject(studentServiceUrl + feeRequest.getStudentId(), Student.class);

			/*
			 * if (student == null) { throw new
			 * RuntimeException("Student not found with ID: " + feeRequest.getStudentId());
			 * }
			 */

        // Associate fee with student
        Receipt receipt = new Receipt();
//        receipt.setStudentId(student.getId());
//        receipt.setStudentName(student.getName()); 
//        receipt.setAmount(feeRequest.getAmount());
//        receipt.setCollectionDate(new Date());
        
        return null;
//        return receiptRepository.save(receipt);
    }
    

    public List<Receipt> getReceiptsByStudentId(Long studentId) {
    	return null;
//        return receiptRepository.findByStudentId(studentId);
    }


	public List<Receipt> findAllReceipts() {
		return null;
//        return receiptRepository.findAll();

	}
}
