package com.fees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fees.entity.Receipt;
import com.fees.service.FeeService;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
	
	@Autowired
	private FeeService feeService;

	@GetMapping("/receipts/{studentId}")
	public ResponseEntity<List<Receipt>> getReceiptsForStudent(@PathVariable Long studentId) {
		try {
			List<Receipt> receipts = feeService.getReceiptsByStudentId(studentId);
			return new ResponseEntity<>(receipts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/receipts")
	public List<Receipt> getAllReceipts() {
	    return feeService.findAllReceipts();
	}
}
