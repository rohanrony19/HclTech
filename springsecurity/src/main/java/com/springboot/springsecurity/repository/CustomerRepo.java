package com.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springsecurity.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
