package com.springboot.aop;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	public void makeOrder() {
		System.out.println("Order processing");
	}
}
