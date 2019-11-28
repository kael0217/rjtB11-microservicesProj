package com.java.Shopping1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.java.dao.OrderRepository;
import com.java.dto.Order;
import com.java.dto.Order.OrderStatus;

@EnableJpaRepositories(basePackages= "com.java.dao")
@EntityScan(basePackages= {"com.java.dto"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class} )
@SpringBootApplication(scanBasePackages = {"com.java"} )
@EnableTransactionManagement
public class Shopping1Application {

	@Autowired DatabaseConfig cfg;
	
	public static void main(String[] args) {
		SpringApplication.run(Shopping1Application.class, args);
	}
	
	@Bean
	//@Primary
	public DataSource datasource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setUrl(cfg.getDb().getUrl());
		ds.setDriverClassName(cfg.getDb().getDriverClassName());
		ds.setPassword(cfg.getDb().getPassword());
		ds.setUsername(cfg.getDb().getUsername());
		return ds;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() throws IOException {
		return factory().unwrap(EntityManagerFactory.class);
	}
	
	public SessionFactory factory() throws IOException {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(datasource());
		bean.setPackagesToScan("com.java.dto");
		Properties prop = new Properties();
		prop.setProperty(Environment.HBM2DDL_AUTO, "create");
		prop.setProperty(Environment.DIALECT, PostgreSQL9Dialect.class.getName());
		bean.setHibernateProperties(prop);
		bean.afterPropertiesSet();
		return bean.getObject();
	}

	@Bean
	public CommandLineRunner populateReviews() {
		return new OrderPopulator();
	}
	
	public class OrderPopulator implements CommandLineRunner {
		
		@Autowired OrderRepository op;

		@Override
		public void run(String... args) throws Exception {
			Map<String, Integer> m1 = new HashMap<>();
			m1.put("str", 2);
			m1.put("tyu", 3);
			Order o1 = Order.builder().productList(m1).username("kaigew").totalPrice(1234.21).status(OrderStatus.Confirmed).build();
			Order o2 = Order.builder().productList(m1).username("ninaw").totalPrice(1234.21).status(OrderStatus.Initiated).build();
			op.save(o1);
			op.save(o2);
		}
	}

}
