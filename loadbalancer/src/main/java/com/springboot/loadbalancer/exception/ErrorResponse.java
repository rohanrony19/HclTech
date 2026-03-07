package com.springboot.loadbalancer.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private String messge;
	private LocalDateTime timestamp;
}
