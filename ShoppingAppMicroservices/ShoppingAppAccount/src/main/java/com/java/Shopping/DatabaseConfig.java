package com.java.Shopping;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="spring")
@EnableTransactionManagement(proxyTargetClass=false)
public class DatabaseConfig {
	Db db;
	@Data
	static class Db{
		String url;
		String username;
		String password;
		String driverClassName;
	}
	Jpa jpa;
	@Data
	static class Jpa{
		String showSql;
		String generateDdl;
	}
}
