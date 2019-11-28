package com.java.ShoppingAppPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClientURI;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="spring.data")
@EnableTransactionManagement(proxyTargetClass=false)
public class DatabaseConfig {
	Mongodb mongodb ;
	@Data
	static class Mongodb{
		String port;
		String host;
	}
}
