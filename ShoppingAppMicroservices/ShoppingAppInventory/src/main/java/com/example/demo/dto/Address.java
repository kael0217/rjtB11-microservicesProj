package com.example.demo.dto;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {
	
	int hno;
	String street;
	String city;
	String state;
	int pincode;

}
