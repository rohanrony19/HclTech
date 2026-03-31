package com.springboot.jmsorderproducer;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderMessage implements Serializable{

	private Long orderId;
	private Long customerId;
	private String product;
	
}
