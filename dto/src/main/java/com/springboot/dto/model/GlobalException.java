package com.springboot.dto.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.dto.exception.ProductException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handler(MethodArgumentNotValidException ex){
		
		Map<String,String> error = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err -> error.put(err.getField(), err.getDefaultMessage()));
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(exception = ProductException.class)
	public ResponseEntity<ErrorResponse> pException(ProductException ex){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessge(ex.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return ResponseEntity.badRequest().body(error);
	}
	
	
}
