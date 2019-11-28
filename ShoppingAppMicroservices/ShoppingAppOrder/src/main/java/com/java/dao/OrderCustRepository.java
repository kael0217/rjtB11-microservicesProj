package com.java.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.java.dto.Order;
import com.java.dto.Order.OrderStatus;

public interface OrderCustRepository {
	
	List<Order> findByUsername( String username );
	
	//@RestResource
	@Query(nativeQuery=true, value="select * from Orders where date > ?2 and username=?1")
	List<Order> findOrderByUsernameAndAfterDate( String username, LocalDate date );
	
}
