package com.springboot.transactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.transactional.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
