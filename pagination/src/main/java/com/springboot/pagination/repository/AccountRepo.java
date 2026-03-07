package com.springboot.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pagination.model.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
