package com.java.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.java.dto.Payment;

public interface PaymentCustRepository {

	public List<Payment> findByOrderId( Integer orderId );

	public List<Payment> findByUsername( String username );

	@Query(value="{username:?0, {time:{$gt:?1}} ")
	public List<Payment> findByUsernameAndDateAfter( String username, LocalDateTime time);
	
	
	
}
