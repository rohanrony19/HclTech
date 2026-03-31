package com.springboot.aop;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public void makePayment() {
		System.out.println("Payment processing...");
	}
}
