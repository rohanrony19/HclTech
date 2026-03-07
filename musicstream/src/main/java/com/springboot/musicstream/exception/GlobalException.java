package com.springboot.musicstream.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(exception = ArtistException.class)
	public ResponseEntity<ErrorResponse> ArtException(ArtistException ex){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessge(ex.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(exception = TracksException.class)
	public ResponseEntity<ErrorResponse> tracException(TracksException ex){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessge(ex.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return ResponseEntity.badRequest().body(error);
	}
}
