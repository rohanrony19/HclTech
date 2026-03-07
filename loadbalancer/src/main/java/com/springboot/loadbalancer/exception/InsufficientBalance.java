package com.springboot.loadbalancer.exception;

public class InsufficientBalance extends RuntimeException{

	public InsufficientBalance(String msg) {
		super(msg);
	}
	
}
