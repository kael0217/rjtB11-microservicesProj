package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ShippingRepository;
import com.example.demo.dto.Shipping;


@Service
public class ShippingServiceImpl implements ShippingService {

	@Autowired ShippingRepository srp;



	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public int addShipping(Shipping shipping) {
		Shipping sh = srp.save(shipping);
		return sh.getId();
	}

	@Override
	public List<Shipping> getShipping() {
		return srp.findAll();
	}

	@Override
	public List<Shipping> getShippingBySenderId(String senderId) {
		return srp.getShippingBySenderId(senderId);
	}

	@Override
	public Shipping getShippingByOrderId(String orderId) {
		return srp.getShippingByOrderId(orderId);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public boolean updateShipping(Shipping shipping) {
		try {
			srp.save(shipping);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public boolean deleteShipping(int shippingId) {
		try {
			srp.deleteById(shippingId);
		}catch( Exception e ) {
			return false;
		}
		return true;
	}





}
