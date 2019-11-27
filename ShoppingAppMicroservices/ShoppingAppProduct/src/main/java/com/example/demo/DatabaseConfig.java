package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="spring.data")
public class DatabaseConfig {

	Mongodb mongodb ;
	@Data
	static class Mongodb{
		String port;
		String host;
	}

}
