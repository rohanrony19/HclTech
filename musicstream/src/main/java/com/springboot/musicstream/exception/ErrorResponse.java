package com.springboot.musicstream.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private String messge;
	private LocalDateTime timestamp;
}
