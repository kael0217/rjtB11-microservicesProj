package com.java.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AccountRepository;
import com.java.dto.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired AccountRepository ar;

	public boolean login(String accountId, String password ) {
		Optional<Account> acc = ar.findById(accountId);
		if( acc.isPresent() ) {
			Account temp = acc.get();
			if( password.compareTo( temp.getPassword() ) == 0 && !temp.isLogin() ) {
				temp.setLogin(true);
				ar.save(temp);
				return true;
			}
			else
				return false;
		}
		else {
			return false;
		}
	}

	public Account retrieveAccountById(String accountId ) {
		Optional<Account> acc = ar.findById(accountId);
		if( acc.isPresent() ) {
			return acc.get();
		}
		return null;
	}
	
	public boolean updateAccountAddress( String accountId, String address, Integer index ) {
		ar.changeAccountAddress(accountId, address, index);
		return true;
	}
	
	public boolean updateAccountPho( String accountId, Long phno ) {
		ar.changeAccountPhoneNumber(accountId, phno);
		return true;
	}
	
	public boolean updateAccountEmail( String accountId, String email ) {
		ar.changeAccountEmail(accountId, email);
		return true;
	}
	
	public boolean logout( String accountId ) {
		Optional<Account> acc = ar.findById(accountId);
		if( acc.isPresent() ) {
			Account temp = acc.get();
			if( temp.isLogin() ) {
				temp.setLogin(false);
				ar.save(temp);
				return true;
			}
			else
				return false;
		}
		else {
			return false;
		}
	}
	
}
