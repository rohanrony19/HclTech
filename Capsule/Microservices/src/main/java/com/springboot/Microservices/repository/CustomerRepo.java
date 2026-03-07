package com.springboot.Microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Microservices.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
