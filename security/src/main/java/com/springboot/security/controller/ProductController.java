package com.springboot.security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.springboot.crudoperation.exception.CustomException;
//import com.springboot.crudoperation.model.Customer;
import com.springboot.security.model.Product;
import com.springboot.security.service.ProductService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping("/v1")
	public ResponseEntity<Product> save(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}
	
	@GetMapping("/{v2}")
	public ResponseEntity<Product> getById(@PathVariable(name="v2") Long id)  {
		Product p = productService.getById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
//	@DeleteMapping("/v2")
//	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
//		return ResponseEntity.noContent().build();
//	}
}
