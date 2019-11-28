package com.example.demo.dto;


import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Cart {

	@Id
	@GeneratedValue
	private Integer id;
	private String customerId;
	@ElementCollection
	private Map<String, Integer> itemsMap;
}
