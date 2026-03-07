package com.springboot.pagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pagination.model.Account;
import com.springboot.pagination.service.AccountInterface;

@RestController
public class AccountController {

	private final AccountInterface accountInterface;

	public AccountController(AccountInterface accountInterface) {
		super();
		this.accountInterface = accountInterface;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Account> save(@RequestBody Account acc){
		return ResponseEntity.status(HttpStatus.CREATED).body(accountInterface.addAccount(acc));
	}
	
	@GetMapping("/get")
	public ResponseEntity<Page<Account>> getAll(Pageable page){
		return ResponseEntity.status(HttpStatus.CREATED).body(accountInterface.getAll(page));
	}
}
