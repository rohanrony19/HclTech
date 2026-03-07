package com.springboot.Microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Microservices.model.Customer;
import com.springboot.Microservices.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Customer cust){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cust));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAll(){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.getAll());
	}
}
