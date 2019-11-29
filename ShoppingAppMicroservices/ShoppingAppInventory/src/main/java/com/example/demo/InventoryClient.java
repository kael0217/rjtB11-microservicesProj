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
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//@EnableTransactionManagement(proxyTargetClass=false)
@EnableJpaRepositories(basePackages= {"com.example.demo.dao"})
@EntityScan(basePackages= {"com.example.demo.dto"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class} )

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=false)
@EnableAspectJAutoProxy(proxyTargetClass=false)
public class InventoryClient {

	public static void main(String[] args) {
		SpringApplication.run(InventoryClient.class, args);
	}
	
	
	

}
