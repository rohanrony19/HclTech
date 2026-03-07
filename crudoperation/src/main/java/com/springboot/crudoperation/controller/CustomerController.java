package com.springboot.crudoperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudoperation.exception.CustomException;
import com.springboot.crudoperation.model.Customer;
import com.springboot.crudoperation.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Customer cus) {
		customerService.save(cus);
		return ResponseEntity.status(HttpStatus.CREATED).body("Saved succesfully");
	}
	
	@GetMapping("/getData")
	public List<Customer> f1() {
		System.out.println("get");
		return customerService.getAll();
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id,@RequestBody Customer cus){
		customerService.updateCustomer(id, cus);
		return ResponseEntity.status(HttpStatus.CREATED).body("updated");
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Customer> getById(@PathVariable Integer id) throws CustomException {
		Customer cus = customerService.findById(id);
		return ResponseEntity.ok().body(cus);
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name){
		customerService.deleteByName(name);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted");
	}
}
