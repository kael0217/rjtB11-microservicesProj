package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;

@Transactional
public interface AccountRepository extends JpaRepository<Account, String>, AccountCustRepository{
	
}
