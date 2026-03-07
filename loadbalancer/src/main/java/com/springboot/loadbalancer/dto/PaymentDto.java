package com.springboot.loadbalancer.dto;

import java.time.LocalDate;

import com.springboot.loadbalancer.model.Type;


import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PaymentDto {

	private Long id;

	private Type type;

	private LocalDate date;

	@Positive(message = "Amount must be positive")
	private double amount;

	public PaymentDto() {
		super();
		this.type = Type.Online;
	}
}
