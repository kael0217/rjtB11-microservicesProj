package com.java.ShoppingAppPayment;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.java.dao.PaymentRepository;
import com.java.dto.Payment;
import com.java.dto.Payment.Action;
import com.java.dto.Payment.PaymentMethod;

@EnableMongoRepositories(basePackages= {"com.java.dao"})
@EntityScan(basePackages= {"com.example.demo.dto"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class} )
@SpringBootApplication(scanBasePackages = "com.java")
@EnableTransactionManagement
public class ShoppingAppPaymentApplication {
	
	@Autowired PaymentRepository pr;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingAppPaymentApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner populateReviews() {
		return new PaymentPopulator();
	}
	
	public class PaymentPopulator implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			Payment o1 = Payment.builder().orderId(1234).username("kaigew").amount(21.21).action(Action.Payment).time(LocalDateTime.now()).method(PaymentMethod.ApplePay).build();
			Payment o2 = Payment.builder().orderId(1235).username("ninaw").amount(12.21).action(Action.Payment).time(LocalDateTime.now()).method(PaymentMethod.Cash).build();
			pr.save(o1);
			pr.save(o2);
		}
	}

}
