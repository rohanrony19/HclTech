package com.springboot.dto.controller;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.model.ProductDto;
import com.springboot.dto.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService ps;

	@Autowired
	public ProductController(ProductService ps) {
		this.ps=ps;
	}
	
	@PostMapping("/save")
	public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto dto){
		ProductDto dt = ps.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dt);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ProductDto> findbyId(@PathVariable Integer id){
		ProductDto d = ps.findById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(d);
	}
	
}
