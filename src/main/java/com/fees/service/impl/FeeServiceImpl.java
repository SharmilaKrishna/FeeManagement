package com.fees.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.fees.dto.FeesDto;
import com.fees.dto.ItemDto;
import com.fees.entity.Fees;
import com.fees.entity.ItemDetail;
import com.fees.entity.Receipt;
import com.fees.entity.Student;
import com.fees.repository.FeeRepository;
import com.fees.repository.ItemDetailRepository;
import com.fees.repository.ReceiptRepository;
import com.fees.service.FeeService;

@Service	
public class FeeServiceImpl implements FeeService {

	@Autowired
	private FeeRepository feeRepository;

	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired
	private ItemDetailRepository itemDetailRepository;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@Value("${student.service.url}")
	private String studentServiceUrl;
	
	@Transactional
	@Override
	public Fees createFeeAndReceipt(FeesDto feesDto) {
		
		
		if (ObjectUtils.isEmpty(feesDto)) {
	        throw new IllegalArgumentException("Provided FeesDto cannot be null");
	    }
		
		Student student = restTemplate.getForObject(studentServiceUrl + feesDto.getStudentId(), Student.class);
		
		if (ObjectUtils.isEmpty(student)) {
			throw new RuntimeException("Student not found with ID: " + feesDto.getStudentId());
		}

	    Fees fee = new Fees(feesDto.getStudentId(), feesDto.getAmount(), feesDto.getPaymentDate(), feesDto.getStatus());
	    fee = feeRepository.save(fee);

	    if (fee == null || feesDto.getCardNumber() == null || feesDto.getCardType() == null) {
	        throw new IllegalArgumentException("Card details must not be null");
	    }
	    Receipt receipt = new Receipt(fee, student.getName(), feesDto.getReferenceNumber(),
	                                  feesDto.getCardNumber(), feesDto.getCardType());
	    receipt = receiptRepository.save(receipt);

	    final Receipt finalReceipt = receipt; 
	    if (feesDto.getItemDto() != null && !feesDto.getItemDto().isEmpty()) {
	        List<ItemDetail> items = feesDto.getItemDto().stream()
	            .map(i -> new ItemDetail(finalReceipt, i.getDescription(), i.getAmount()))
	            .collect(Collectors.toList());
	        itemDetailRepository.saveAll(items);
	    }
	    return fee;
	}
	
	@Transactional(readOnly = true)
	@Override
    public FeesDto getFeesDtoById(Long feesId) {
        FeesDto feesDto = feeRepository.findFeesDtoById(feesId);
        if (feesDto != null && feesDto.getReceiptId() != null) {
            List<ItemDetail> itemDetails = itemDetailRepository.findByReceiptReceiptId(feesDto.getReceiptId());
            List<ItemDto> itemDtos = itemDetails.stream()
                .map(item -> new ItemDto(item.getItemId(), item.getDescription(), item.getAmount()))
                .collect(Collectors.toList());
            feesDto.setItemDto(itemDtos);
        }
        return feesDto;
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
	public void deleteItemDetail(Long id) {
		itemDetailRepository.deleteById(id);
	}

	@Override
	public List<Receipt> getReceiptsByStudentId(Long studentId) {
		return null;
	}

	@Override
	public ItemDetail saveItemDetail(ItemDetail itemDetail) {
		return itemDetailRepository.save(itemDetail);
	}

	@Override
	public ItemDetail getItemDetailById(Long id) {
		return itemDetailRepository.findById(id).orElse(null);
	}

	@Override
	public List<ItemDetail> getAllItemDetails() {
		return itemDetailRepository.findAll();
	}
}
