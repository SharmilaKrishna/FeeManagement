package com.fees.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fees.entity.FeeRequest;
import com.fees.entity.Receipt;
import com.fees.service.FeeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Fee Controller", description = "The Fee Controller provides CRUD operations for Fees")
@RestController
@RequestMapping("/fees")
public class FeeController {

	@Autowired
	private FeeService feeService;

	@PostMapping("/collect")
	public ResponseEntity<Receipt> collectFee(@RequestBody FeeRequest feeRequest) {
		try {
			Receipt receipt = feeService.collectFee(feeRequest);
			return new ResponseEntity<>(receipt, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


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
