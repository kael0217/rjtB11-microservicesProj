package com.java.dto;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
	// will use relational database
	@Id// (strategy=GenerationType.AUTO)
	private String username;
	private String password;
	private boolean isLogin;
	@Enumerated
	private Gender gender;
	@Enumerated
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
		male, female
	}
	
}


