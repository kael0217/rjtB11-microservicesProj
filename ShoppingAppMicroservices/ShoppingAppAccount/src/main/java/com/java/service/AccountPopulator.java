package com.java.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.java.dao.AccountRepository;
import com.java.dto.Account;
import com.java.dto.Account.Gender;
import com.java.dto.Account.UserRole;

@Service
public class AccountPopulator implements CommandLineRunner {
	
	@Autowired AccountRepository ap;

	@Override
	public void run(String... args) throws Exception {
		Account a1 = Account.builder().addresses(Arrays.asList("Irvine")).email("a@b.c").gender(Gender.male).isLogin(false).mobile(1234567l).password("wkg45678").role(UserRole.ROLE_USER).username("kaigew").build();
		ap.save(a1);
	}
	
}
