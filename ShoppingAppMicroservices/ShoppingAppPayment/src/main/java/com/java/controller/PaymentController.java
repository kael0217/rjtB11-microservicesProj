package com.java.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.PaymentRepository;
import com.java.dto.Payment;

@RequestMapping("/payments")
@RestController
public class PaymentController {
	
	@Autowired PaymentRepository pr;
	
	@PostMapping
	public boolean insertPayment( Payment payment ) {
		pr.save(payment);
		return true;
	}
	
	@GetMapping("/{paymentId}")
	public Payment retrievePayment( @PathVariable String paymentId ) {
		Optional<Payment> p = pr.findById(paymentId);
		if( p.isPresent() )
			return p.get();
		return null;
	}
	
	@GetMapping("/list/{username}")
	public List<Payment> retrievePaymentList( @PathVariable String username ) {
		return pr.findByUsername(username);
	}
	
	@GetMapping("/order/{orderId}")
	public List<Payment> retrievePaymentListByOrderId( @PathVariable Integer orderId ) {
		return pr.findByOrderId(orderId);
	}
	
	@PatchMapping
	public boolean updatePayment( Payment payment ) {
		Optional<Payment> p = pr.findById(payment.getPaymentId());
		if( p.isPresent() ) {
			pr.save(payment);
			return true;
		}
		return false;
	}
	
	@DeleteMapping("/{paymentId}")
	public boolean updatePayment( @PathVariable String paymentId ) {
		Optional<Payment> p = pr.findById(paymentId);
		if( p.isPresent() ) {
			pr.deleteById(paymentId);
			return true;
		}
		return false;
	}
}
