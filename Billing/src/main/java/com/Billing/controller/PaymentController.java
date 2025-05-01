package com.Billing.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Billing.entity.Payment;
import com.Billing.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {


	    @Autowired
	    private PaymentService service;

	    //http://localhost:9000/add
	    @PostMapping("/create")
	    public ResponseEntity<Payment> create(@Validated @RequestBody Payment payment) {
	        return new  ResponseEntity<>(payment, HttpStatus.CREATED);
	    }

	    @GetMapping("/date/{date}")
	    public ResponseEntity<List<Payment>> getByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	        return ResponseEntity.ok(service.findByDate(date));
	    }

	}

   





































/*
@GetMapping("/{id}")
public ResponseEntity<Payment> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
}

@PutMapping("/refund/{id}")
public ResponseEntity<Payment> refund(@PathVariable Long id) {
    return ResponseEntity.ok(service.refund(id));
}

@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.ok("Payment deleted successfully");
}
*/