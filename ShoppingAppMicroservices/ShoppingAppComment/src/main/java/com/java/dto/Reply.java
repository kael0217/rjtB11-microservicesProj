package com.java.dto;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class Reply {
	private String username;
	private String text;
	
	
	@Override
	public String toString() {
		String result = username + ":    "+ text; 
		return result;
	}
}
