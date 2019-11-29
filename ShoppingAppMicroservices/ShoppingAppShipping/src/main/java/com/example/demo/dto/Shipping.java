package com.example.demo.dto;


import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Shipping {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Embedded
	private Address address;
	@Default
	private String customerName = "anonymous";
	private int storeId;
	private String orderId;
	private float weight;
	private float price;
}
