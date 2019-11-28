package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.dao.PaymentRepository;
import com.java.dto.Payment;

public class PaymentServiceImpl implements PaymentService {

	@Autowired PaymentRepository pr;
	
	@Override
	public boolean askForRefund(String paymentId) {
		return false;
		
	}

	@Override
	public boolean updatePaymentType(String paymentId, String paymentMethod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPayment(Payment pay) {
		return false;
		
	}
	
	
	
}
