package com.example.demo;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClient;


@EnableMongoRepositories(basePackages= {"com.example.demo.dao"})
@EntityScan(basePackages= {"com.example.demo.dto"})

@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class} )
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages="com.example.demo")
public class ProductClient {

	@Autowired DatabaseConfig cfg;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductClient.class, args);
	}
/*
	@Bean
	public MongoClient client() {
		return new MongoClient("localhost", 27017);
	}*/
}
