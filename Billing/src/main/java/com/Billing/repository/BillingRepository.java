package com.Billing.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Billing.entity.Payment;

public interface BillingRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByPaymentDate(LocalDate date);
	
	
	
}
