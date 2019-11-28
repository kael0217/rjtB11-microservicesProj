package com.java.Shopping;

import java.io.IOException;
import java.util.Arrays;
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

import com.java.dao.AccountRepository;
import com.java.dto.Account;
import com.java.dto.Account.Gender;
import com.java.dto.Account.UserRole;

@EnableJpaRepositories(basePackages= "com.java.dao")
@EntityScan(basePackages= {"com.java.dto"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class} )
@SpringBootApplication(scanBasePackages = {"com.java"})
@EnableTransactionManagement
public class ShoppingApplication {

	@Autowired DatabaseConfig cfg;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
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
		return new AccountPopulator();
	}
	
	public class AccountPopulator implements CommandLineRunner {
		
		@Autowired AccountRepository ap;

		@Override
		public void run(String... args) throws Exception {
			Account a1 = Account.builder().username("kaigew").password("wkg").isLogin(false).role(UserRole.ROLE_USER).email("a@b.c").gender(Gender.male).mobile(123456789l).addresses(Arrays.asList("irvine","stcharles")).build();
			Account a2 = Account.builder().username("ninaw").password("wkg").isLogin(true).role(UserRole.ROLE_USER).email("a@b.c").gender(Gender.male).mobile(123456789l).addresses(Arrays.asList("irvine","stcharles")).build();
			ap.save(a1);
			ap.save(a2);
		}
	}

}
;