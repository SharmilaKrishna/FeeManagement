package com.fees.controller;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fees.dto.FeesDto;
import com.fees.service.FeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Fee Controller", description = "Controller for managing fees, receipts, and purchase details")
@RestController
@RequestMapping("/api")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @Operation(summary = "Create a fee and receipt", description = "Create a new fee and associated receipt from the provided DTO")
    @PostMapping("/fee")
    public ResponseEntity<?> createFee(@RequestBody @Validated FeesDto feesDto) {
        if (feesDto.getAmount() == null || feesDto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest().body("Amount must be greater than zero.");
        }

        return ResponseEntity.ok(feeService.createFeeAndReceipt(feesDto));
    }


    @Operation(summary = "Get a fee by ID", description = "Retrieve detailed fee information by its ID")
    @GetMapping("/fees/{id}")
    public ResponseEntity<FeesDto> getFeeById(@PathVariable Long id) {
        FeesDto feesDto = feeService.getFeesDtoById(id);
        return feesDto != null ? ResponseEntity.ok(feesDto) : ResponseEntity.notFound().build();
    }
    
    @Operation(summary = "Get a fee by ID", description = "Retrieve detailed fee information by its ID")
    @GetMapping("/fees/student/{studentId}")
    public List<FeesDto> getReceiptId(@PathVariable Long studentId) {
        List<FeesDto> receiptsByStudentId = feeService.getFeeByStudentId(studentId);
        return receiptsByStudentId;
    }

}
