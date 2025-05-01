package com.Billing.service;

import java.time.LocalDate;

public interface IPayment {
	
	//Create payment (Added New Payment )
	boolean createPayement();
	
   // Read payments ( specific date)
	public void readAllPayment(LocalDate date);
	
    // Read single payment (Read One Payment Method As Given By)
	public void readPaymentById(Integer id);
   
	// Refund payment (When process are Failed Then Refunded Your Money)
	public void refundpayment(Integer id);
	
  // Delete payment (Delete Payment On billing)
	public void deletepayment(Integer id);

}
