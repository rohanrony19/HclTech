package com.springboot.pagination.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.pagination.model.Account;

public interface AccountInterface {

	public Account addAccount(Account acc);
	
	public void deleteAccount(Long id);
	
	public Account getById(Long id);
	
	public Page<Account> getAll(Pageable page);
}
