package com.example.reactivestream.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Users {

	@Id
	private Long id;
	
	private String name;
	
	private Long number;
	
	private String email;
	
	private String place;
}
