package com.springboot.loadbalancer.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Payment {

	@Id
	private Long id;
	
	private Type type ;
	
	private LocalDate date;
	
	private double amount;
	
}
