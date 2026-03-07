package com.springboot.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springsecurity.model.Customer;
import com.springboot.springsecurity.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAll(){
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.getAll());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getById(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.getById(id));
	}
	
}
