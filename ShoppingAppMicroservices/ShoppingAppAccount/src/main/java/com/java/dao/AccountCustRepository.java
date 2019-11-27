package com.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import com.java.dto.Account;

public interface AccountCustRepository {
	
	@RestResource
	@Query(nativeQuery=true, value="select * from Account where role = ?1 ")
	List<Account> getAccountByAccType( String type );
	
	@RestResource
	@Query(nativeQuery=true, value="update table Account_address set address=?2 where accountId = ?1 and index = ?3")
	void changeAccountAddress( String accountId, String address, Integer index );
	
	@RestResource
	@Query(nativeQuery=true, value="update table Account set mobile = ?2 where username = ?1 ")
	void changeAccountPhoneNumber( String accountId, Long phno );
	
	@RestResource
	@Query(nativeQuery=true, value="update table Account set email = ?2 where username = ?1")
	void changeAccountEmail( String accountId, String email );
	
	@RestResource
	@Query(nativeQuery=true, value="update table Account set isLogin = ?2 where username = ?1")
	void changeAccountStatus( String accountId, String value );
	
}
