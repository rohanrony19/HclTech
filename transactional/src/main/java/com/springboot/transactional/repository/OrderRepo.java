package com.springboot.transactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.transactional.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
