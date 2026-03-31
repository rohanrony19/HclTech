package com.springboot.jmsorderconsumer;

import org.springframework.jms.annotation.JmsListener; 
import org.springframework.stereotype.Service;

import com.springboot.jmsorderproducer.OrderMessage;

@Service
public class CustomerConsumer {

	@JmsListener(destination = "order.queue")
	public void receiveOrder(OrderMessage order) {
		System.out.println("Received Order");
		
		System.out.println(order.getCustomerId());
		System.out.println(order.getProduct());
		System.out.println(order.getOrderId());
	}
}
