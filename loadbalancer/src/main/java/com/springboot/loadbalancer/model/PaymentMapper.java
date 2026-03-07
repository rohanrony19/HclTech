package com.springboot.loadbalancer.model;

import com.springboot.loadbalancer.dto.PaymentDto;

public class PaymentMapper {

	public static Payment toEntity(PaymentDto dto) {
		Payment payment = new Payment();
		payment.setId(dto.getId());
		payment.setType(dto.getType());
		payment.setDate(dto.getDate());
		payment.setAmount(dto.getAmount());
		return payment;
	}
	
	public static PaymentDto toDto(Payment payment) {
		PaymentDto dto = new PaymentDto();
		dto.setId(payment.getId());
		dto.setType(payment.getType());
		dto.setDate(payment.getDate());
		dto.setAmount(payment.getAmount());
		return dto;
	}
}
