package com.java.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.AccountRepository;
import com.java.dto.Account;

@RequestMapping("/accounts")
@RestController
public class AccountController {
	
	@Autowired AccountRepository ar;
	
	@PostMapping(path="/register")
	public boolean addAccount( Account account ) {
		if( ar.findById(account.getUsername()).isPresent() )
			return false;
		else {
			ar.save( account );
			return true;
		}
	}
	
	@PostMapping(path="/login")
	public boolean login( @RequestParam String accountId, @RequestParam String password ) {
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
	
	@PostMapping(path="/logout/{accountId}")
	public boolean logout( @PathVariable String accountId ) {
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
	
	@GetMapping(path="/login/{accountId}")
	public Account retrieveAccountById(@PathVariable String accountId ) {
		Optional<Account> acc = ar.findById(accountId);
		if( acc.isPresent() ) {
			return acc.get();
		}
		return null;
	}
	
	@PatchMapping
	public boolean updateAccount( Account account ) {
		if( !ar.findById(account.getUsername()).isPresent() )
			return false;
		ar.save(account);
		return true;
	}

	@DeleteMapping(path="/{accountId}")
	public boolean deleteAccount(@PathVariable String accountId ) {
		if( !ar.findById(accountId).isPresent() )
			return false;
		ar.deleteById(accountId);
		return true;
	}
	
}
