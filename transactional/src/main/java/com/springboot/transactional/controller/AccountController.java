package com.springboot.transactional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.transactional.model.Account;
import com.springboot.transactional.service.AccountService;

@RestController
public class AccountController {

	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping("/account/{id}/deposit")
	public Account deposit(@PathVariable("id") Long id,@RequestParam double amount) throws InterruptedException{
		return accountService.deposit(id, amount);
	}
	
	@PostMapping("/account/{id}/withdraw")
	public Account withdraw(@PathVariable("id") Long id,@RequestParam double amount){
		return accountService.withdraw(id, amount);
	}
	
	
}
