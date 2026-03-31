package com.springboot.jmsorderproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderProducer ord;
	
	@PostMapping
	public String createOrder(@RequestBody OrderMessage order) {
		ord.sendOrder(order);
		return "Order sent to JMS Queue";
	}
}
