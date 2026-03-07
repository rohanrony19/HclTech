package com.springboot.customannotation;

import lombok.Data;

@Data
public class UserDto {

	private String name;
	
	@Adult(18)
	private Integer age;
}
