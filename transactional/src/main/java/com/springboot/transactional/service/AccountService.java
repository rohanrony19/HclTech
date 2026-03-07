package com.springboot.transactional.service;

import org.springframework.stereotype.Service;

import com.springboot.transactional.model.Account;
import com.springboot.transactional.repository.AccountRepo;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

	private final AccountRepo accRep;

	public AccountService(AccountRepo accRep) {
		super();
		this.accRep = accRep;
	}
	
	
	@Transactional
	public Account deposit(Long id,double amount) throws InterruptedException {
		Account acc = accRep.findByIdUpdate(id);
		acc.setAccBalance(acc.getAccBalance()+amount);
		Thread.sleep(20000);
		return accRep.save(acc);
		
	}
	
	@Transactional
	public Account withdraw(Long id,double amount) {
		Account acc = accRep.findByIdUpdate(id);
		if(acc.getAccBalance() < amount) {
			throw new RuntimeException("Check your balance");
		}
		acc.setAccBalance(acc.getAccBalance()-amount);
		return accRep.save(acc);
	}
}
