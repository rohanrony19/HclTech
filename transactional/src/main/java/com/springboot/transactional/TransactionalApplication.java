package com.springboot.transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.transactional.model.Account;
import com.springboot.transactional.repository.AccountRepo;

@SpringBootApplication
public class TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(AccountRepo repo) {
//		return arg->{
//			Account acc = new Account();
//			acc.setAccName("xyz");
//			acc.setAccBalance(4000);
//			repo.save(acc);
//		};
//	}
}
