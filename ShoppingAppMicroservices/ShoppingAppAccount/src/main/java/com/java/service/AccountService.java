package com.java.service;

import com.java.dto.Account;

public interface AccountService {
	
	public boolean login(String accountId, String password );

	public Account retrieveAccountById(String accountId );
	
	public boolean updateAccountAddress( String accountId, String address, Integer index );
	
	public boolean updateAccountPho( String accountId, Long phno );
	
	public boolean updateAccountEmail( String accountId, String email );
	
	public boolean logout( String accountId );
	
}
