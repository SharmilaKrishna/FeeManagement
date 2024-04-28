package com.fees.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeesDto {

    private Long studentId;
    private BigDecimal amount;
    private Date paymentDate;
    private String status;
    private String studentName;
    private String referenceNumber;
    private String cardNumber;
    private String cardType;
    private Long receiptId;
    private List<ItemDto> itemDto;
    
    

    public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	public BigDecimal getAmount() {
		return amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public Date getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public String getReferenceNumber() {
		return referenceNumber;
	}



	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}



	public String getCardType() {
		return cardType;
	}



	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	public Long getReceiptId() {
		return receiptId;
	}



	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}



	public List<ItemDto> getItemDto() {
		return itemDto;
	}



	public void setItemDto(List<ItemDto> itemDto) {
		this.itemDto = itemDto;
	}



	public FeesDto(Long studentId, BigDecimal amount, Date paymentDate, String status,
                   String studentName, String referenceNumber, String cardNumber, String cardType,
                   Long receiptId) {
        this.studentId = studentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.studentName = studentName;
        this.referenceNumber = referenceNumber;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.receiptId = receiptId; 
    }
}
