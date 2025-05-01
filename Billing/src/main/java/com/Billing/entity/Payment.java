package com.Billing.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
	@Id
	@Column(length=50)
	private int paymentId ;
	@Column(length=50)
	private int amount;
	
	private PaymentMethod paymentMethod; 
	
	
	private LocalDate paymentDate;
	
	@Column(length=50)
	private String paymentStatus;
	
	public Payment() {
		
	}

	public Payment(int paymentId, int amount, PaymentMethod paymentMethod, LocalDate paymentDate,
			String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentMethod=" + paymentMethod
				+ ", paymentDate=" + paymentDate + ", paymentStatus=" + paymentStatus + "]";
	}

	public Object findById(Long id) {
		
		return null;
	}
	
}
