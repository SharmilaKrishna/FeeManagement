package com.fees.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fees")
@Getter
@Setter
public class Fees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fees_id")
    private Long feesId;

    @Column(name = "student_id")
    private Long studentId;

    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    
    private String status;
    
    @OneToOne(mappedBy = "fees")
    private Receipt receipt;
    
    
    
    public Long getFeesId() {
		return feesId;
	}



	public void setFeesId(Long feesId) {
		this.feesId = feesId;
	}



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



	public Receipt getReceipt() {
		return receipt;
	}



	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}



	public Fees(Long studentId, BigDecimal amount, Date paymentDate, String status) {
        this.studentId = studentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }

}
