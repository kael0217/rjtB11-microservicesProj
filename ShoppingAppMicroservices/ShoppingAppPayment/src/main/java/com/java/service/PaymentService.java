package com.java.service;

import com.java.dto.Payment;

public interface PaymentService {
	
	public boolean addPayment(Payment pay);
	
	public boolean askForRefund( String paymentId );
	
	public boolean updatePaymentType(String paymentId, String paymentMethod);
}
