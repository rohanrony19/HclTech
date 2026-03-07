package com.springboot.transactional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.transactional.model.Order;
import com.springboot.transactional.model.Product;
import com.springboot.transactional.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService os;

	@Autowired
	public OrderController(OrderService os) {
		this.os = os;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		os.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(os.saveProduct(product));
	}
	
	@GetMapping("/place/{id}/{quan}")
	public ResponseEntity<Order> placeOrder(@PathVariable  Integer id,@PathVariable int quan){
		Order p = os.placeOrder(id, quan);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
}
