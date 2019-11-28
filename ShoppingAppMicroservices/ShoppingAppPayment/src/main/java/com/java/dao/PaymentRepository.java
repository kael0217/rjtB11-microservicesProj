package com.java.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Payment;

@Transactional
public interface PaymentRepository extends MongoRepository<Payment, String>, PaymentCustRepository{

}
