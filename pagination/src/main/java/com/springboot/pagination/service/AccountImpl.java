package com.springboot.pagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.pagination.model.Account;
import com.springboot.pagination.repository.AccountRepo;

@Service
public class AccountImpl implements AccountInterface{

	
	private final AccountRepo accountRepo;
	
	
	@Autowired
	public AccountImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public Account addAccount(Account acc) {
		return accountRepo.save(acc);
	}

	@Override
	public void deleteAccount(Long id) {
		
	}

	@Override
	public Account getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> getAll(Pageable page) {
		
		return accountRepo.findAll(page);
	}

}
