package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Account;

public interface AccountRepository extends JpaRepository<Account, String>, AccountCustRepository{

}
