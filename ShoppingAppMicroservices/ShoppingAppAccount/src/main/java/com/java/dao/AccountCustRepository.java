package com.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.rest.core.annotation.RestResource;
import com.java.dto.Account;

public interface AccountCustRepository {
	
	//@RestResource
	@Query(nativeQuery=true, value="select * from account where role = ?1 ")
	List<Account> getAccountByAccType( Integer role );
	
	//@RestResource
	@Query(nativeQuery=true, value="update table account_address set addresses=?2 where username = ?1 and index = ?3")
	void changeAccountAddress( String accountId, String address, Integer index );
	
	//@RestResource
	@Query(nativeQuery=true, value="update table account set mobile = ?2 where username = ?1 ")
	void changeAccountPhoneNumber( String accountId, Long phno );
	
	//@RestResource
	@Query(nativeQuery=true, value="update table account set email = ?2 where username = ?1")
	void changeAccountEmail( String accountId, String email );
	
	//@RestResource
	@Query(nativeQuery=true, value="update table Account set isLogin = ?2 where username = ?1")
	void changeAccountStatus( String accountId, String value );
	
}
