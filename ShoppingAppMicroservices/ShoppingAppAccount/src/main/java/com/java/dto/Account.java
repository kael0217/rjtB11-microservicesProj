package com.java.dto;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Builder
public class Account {
	// will use relational database
	@Id
	@GeneratedValue
	private String username;
	private String password;
	private boolean isLogin;
	private Gender gender;
	private UserRole role;
	private Long mobile;
	@ElementCollection
	@OrderColumn(name = "index")
	private List<String> addresses;
	private String email;
	
	public enum UserRole {
		ROLE_ADMIN, ROLE_USER
	}
	
	public enum Gender {
		male,
		female
	}
	
}


