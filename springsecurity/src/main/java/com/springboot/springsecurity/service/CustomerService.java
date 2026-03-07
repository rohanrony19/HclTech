package com.springboot.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springsecurity.model.Customer;
import com.springboot.springsecurity.repository.CustomerRepo;


@Service
public class CustomerService {

	private final CustomerRepo customerRepo;

	@Autowired
	public CustomerService(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
	}
	
	
	public List<Customer> getAll(){
		return customerRepo.findAll();
	}
	
	public Customer getById(Long id) {
		Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		return customer;
	}
	
}
