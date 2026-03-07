package com.springboot.crudoperation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.crudoperation.model.Address;
import com.springboot.crudoperation.model.Company;
import com.springboot.crudoperation.model.Customer;
import com.springboot.crudoperation.model.Gender;
import com.springboot.crudoperation.repository.CustomerRepo;
import com.springboot.crudoperation.service.CustomerService;

@SpringBootApplication
public class CrudoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudoperationApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner cl(CustomerService cs) {
//		return arg->{
//			
//			cs.save(new Customer("Rohan","n", "rohan@hcl.com", 9353715968L,new Address("Shollingnur","Chennai","TN",5600011),new Company("hcl","java"), "image_url1", "rony_19", "password","", new Gender('M','F')));
//		};
//	}
}
