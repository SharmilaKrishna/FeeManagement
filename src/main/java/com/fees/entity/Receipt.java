package com.fees.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "receipt")
@Getter
@Setter
@EqualsAndHashCode(of = {"receiptId"})
@ToString(of = {"receiptId", "transactionDate", "studentName", "referenceNumber", "totalAmount"})
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Long receiptId;

    @OneToOne
    @JoinColumn(name = "fees_id")
    private Fees fees;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    private String studentName;

    private String referenceNumber;

    private String cardNumber;

    private String cardType;

    private BigDecimal totalAmount;
    
    

    public Long getReceiptId() {
		return receiptId;
	}



	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}



	public Fees getFees() {
		return fees;
	}



	public void setFees(Fees fees) {
		this.fees = fees;
	}



	public Date getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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



	public BigDecimal getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}



	public Receipt(Fees fees, String studentName, String referenceNumber, String cardNumber, String cardType) {
        this.fees = fees;
        this.studentName = studentName;
        this.referenceNumber = referenceNumber;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.transactionDate = new Date(); // Defaulting to the current date/time
    }
    
    
}
