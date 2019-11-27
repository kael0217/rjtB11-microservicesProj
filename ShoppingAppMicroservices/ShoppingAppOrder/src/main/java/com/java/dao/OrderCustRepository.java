package com.java.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import com.java.dto.Order;

public interface OrderCustRepository {
	@RestResource
	@Query(nativeQuery=true, value="select * from Order where date > ?1 ")
	List<Order> getOrderListAfterDate( LocalDateTime date );
	
	@RestResource
	@Query(nativeQuery=true, value="update table Order set status = ?2 where orderId = ?1 ")
	List<Order> changeOrderStatus( String orderId, String status );
	
}
