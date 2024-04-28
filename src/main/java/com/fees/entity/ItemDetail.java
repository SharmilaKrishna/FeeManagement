package com.fees.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "item_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    @EqualsAndHashCode.Include
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    private String description;

    private BigDecimal amount;
    
    

    public Long getItemId() {
		return itemId;
	}



	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}



	public Receipt getReceipt() {
		return receipt;
	}



	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public BigDecimal getAmount() {
		return amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public ItemDetail(Receipt receipt, String description, BigDecimal amount) {
        this.receipt = receipt;
        this.description = description;
        this.amount = amount;
    }
}
