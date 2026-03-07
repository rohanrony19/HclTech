package com.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
