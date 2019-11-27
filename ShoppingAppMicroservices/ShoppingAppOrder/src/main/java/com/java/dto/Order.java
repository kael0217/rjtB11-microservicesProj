package com.java.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Builder
public class Order {
	@Id
	@GeneratedValue
	private String orderId;
	private String username;
	private LocalDateTime date;
	@ElementCollection
	@OrderColumn(name = "index")
	private List<String> productId;
	@ElementCollection
	@OrderColumn(name = "index")
	private List<Integer> quantity;
	private OrderStatus status;
	private double totalPrice;
	
	public enum OrderStatus {
		Initiated, Confirmed, Paid, Canceled
	}
	
}