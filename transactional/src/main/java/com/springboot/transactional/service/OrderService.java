package com.springboot.transactional.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.transactional.model.Order;
import com.springboot.transactional.model.Product;
import com.springboot.transactional.repository.OrderRepo;
import com.springboot.transactional.repository.ProductRepo;

import lombok.RequiredArgsConstructor;


//@RequiredArgsConstructor
@Service
public class OrderService {

	private final ProductRepo pr;
	
	private final OrderRepo or;

	@Autowired
	public OrderService(ProductRepo pr, OrderRepo or) {
		super();
		this.pr = pr;
		this.or = or;
	}
	
	public Product saveProduct(Product p) {
		return pr.save(p);
	}
	
	@Transactional
	public Order placeOrder(int productId,int quantity) {
		Product p = pr.findById(productId).orElseThrow(()->new RuntimeException("No id found"));
		if(quantity > p.getStock()) {
			throw new RuntimeException("Less Stock"); 
		}
			p.setStock(p.getStock()-quantity);
			pr.save(p);
//			if (true) {
//				throw new RuntimeException("Something went wrong");
//			}
			Order o = new Order();
			o.setProductId(p.getProductId());
			o.setQuantity(quantity);
			or.save(o);
			return o;
		
	}
	
}
