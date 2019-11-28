package com.java.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
	
	@Id
	@GeneratedValue
	private Integer orderId;
	private String username;
	// private LocalDateTime date;
	
	@ElementCollection
	private Map<String, Integer> productList;
	
	@Enumerated
	private OrderStatus status;
	private double totalPrice;
	
	public enum OrderStatus {
		Initiated, Confirmed, Paid, Canceled
	}
	
}