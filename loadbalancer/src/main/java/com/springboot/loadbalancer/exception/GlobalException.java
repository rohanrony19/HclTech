package com.springboot.loadbalancer.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity<Map<String,String>> handler(RuntimeException ex){

		Map<String,String> error = new HashMap<>();
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(exception = IdNotFound.class)
	public ResponseEntity<ErrorResponse> idException(IdNotFound ex){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessge(ex.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(exception = InsufficientBalance.class)
	public ResponseEntity<ErrorResponse> insufficinet(InsufficientBalance ex){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessge(ex.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return ResponseEntity.badRequest().body(error);
	}
	
}
