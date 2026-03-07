package com.springboot.security.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.security.model.Product;
import com.springboot.security.repository.ProductRepo;

@Service
public class ProductService {

	private final ProductRepo productRepo;

	public ProductService(ProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}
	
	public Product getById(Long id) {
		Product p = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
		return p;
	}
}
