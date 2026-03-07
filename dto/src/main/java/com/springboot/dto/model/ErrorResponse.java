package com.springboot.dto.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private String messge;
	private LocalDateTime timestamp;
}
