package com.springboot.pagination.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accId;
	
	private String accName;
	
	private String location;
	private String address;
	private String email;
	private String contact;
	private double balance;
	private String type;
	private LocalDate createdDate;
	
	
}
