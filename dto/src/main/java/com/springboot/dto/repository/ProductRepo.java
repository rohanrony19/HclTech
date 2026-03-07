package com.springboot.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.dto.model.Product;
import com.springboot.dto.model.ProductDto;

//@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
