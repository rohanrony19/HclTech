package com.springboot.jmsorderproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

	@Autowired
	JmsTemplate jms;
	
	public void sendOrder(OrderMessage order) {
		jms.convertAndSend("order.queue", order);
		System.out.println("order-sent");
	}
}
