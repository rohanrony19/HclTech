package com.springboot.dto.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDto {
	
	private Integer id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@Positive(message = "Must be positive")
	private double price;
}
