package com.example.reactivestream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactivestream.model.Users;
import com.example.reactivestream.service.UsersService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UsersController {

	private final UsersService service;

	@Autowired
	public UsersController(UsersService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Flux<Users>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.getAllUsers());
	}
	
	@GetMapping("/getById/{id}")
	public Mono<Users> getUserById(@PathVariable("id") Long id){
		return service.getUser(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Mono<Users>> save(@RequestBody Users users){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(users));
	}
}
