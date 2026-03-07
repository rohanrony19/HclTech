package com.springboot.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springsecurity.model.Customer;
import com.springboot.springsecurity.service.CustomerService;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/admin")
public class AdminController {

	private final CustomerService customerService;

	@Autowired
	public AdminController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer cust){
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(cust));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id){
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
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
