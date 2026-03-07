package com.springboot.loadbalancer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.loadbalancer.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
