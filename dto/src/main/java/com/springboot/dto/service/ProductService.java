package com.springboot.dto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.exception.ProductException;
import com.springboot.dto.model.Product;
import com.springboot.dto.model.ProductDto;
import com.springboot.dto.model.ProductMapper;
import com.springboot.dto.repository.ProductRepo;

@Service
public class ProductService {
	
	private final ProductRepo pr;
	
	@Autowired
	public ProductService(ProductRepo pr) {
		this.pr=pr;
	}
	
	public ProductDto save(ProductDto dto) {
		Product Entity = ProductMapper.toEntity(dto);
		Product p = pr.save(Entity);
		return ProductMapper.toDto(p);
	}
	
	public ProductDto findById(Integer id) {
		Product prod = pr.findById(id).orElseThrow(()->new ProductException("Product not found"));
		return ProductMapper.toDto(prod);
	}
	
	
	
}
