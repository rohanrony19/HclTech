package com.springboot.aop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {

//	@Autowired
//	private PaymentService paymentService;
//	
//	@Autowired
//	private OrderService orderService;
	
	public static void main(String[] args) {
		var context = SpringApplication.run(AopApplication.class, args);
		PaymentService ser = context.getBean(PaymentService.class);
		ser.makePayment();
		OrderService d = context.getBean(OrderService.class);
		d.makeOrder();
		
	}

}
