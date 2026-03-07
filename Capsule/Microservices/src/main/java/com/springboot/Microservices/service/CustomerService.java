package com.springboot.Microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Microservices.model.Customer;
import com.springboot.Microservices.repository.CustomerRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CustomerService {

	private final CustomerRepo repo;

	@Autowired
	public CustomerService(CustomerRepo repo) {
		super();
		this.repo = repo;
	}
	
	@CircuitBreaker(name="customerService" , fallbackMethod = "fallbackSaveCustomer")
	public String save(Customer cust) {
		int num = (int)(Math.random()*10);
		
		if(num<5) {
			throw new RuntimeException("Database is down!!");
		}
		repo.save(cust);
		return "saved successfully";
	}
	
	public String fallbackSaveCustomer(Customer customer,Throwable throwable) {
		System.out.println("Throwable error " + throwable.getMessage());
		return "I am under Constructor";
	}
	
	public List<Customer> getAll(){
		return repo.findAll();
	}
}
