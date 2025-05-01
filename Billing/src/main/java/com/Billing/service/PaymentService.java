package com.Billing.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Billing.entity.Payment;
import com.Billing.repository.BillingRepository;

@Service
public class PaymentService {



	    @Autowired
	    private BillingRepository repository;

	  
	    public Payment create(Payment payment) {
	        return repository.save(payment);
	    }

	
	    public List<com.Billing.entity.Payment> findByDate(LocalDate date) {
	        return (List<com.Billing.entity.Payment>) repository.findByPaymentDate(date);
	    }
    
	   
	}















