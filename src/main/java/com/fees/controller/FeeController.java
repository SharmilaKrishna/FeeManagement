package com.fees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fees.entity.FeeRequest;
import com.fees.model.Receipt;
import com.fees.service.FeeService;

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

	
}