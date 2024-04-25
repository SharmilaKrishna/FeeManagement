package com.fees.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class FeeRequest {
    	

		@Getter @Setter
	    private Long studentId;

		@Getter @Setter
	    private double amount;
		
		@Getter @Setter
		private String cardNum;
		
		@Getter @Setter
	    private String cardType;
		
		@Getter @Setter
	    private String referenceId;

		public Long getStudentId() {
			return studentId;
		}

		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		
		
	}



