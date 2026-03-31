package com.springboot.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.record.model.Country;
import com.springboot.record.service.CountryService;

@RestController
public class CountryController2 {

	private final CountryService service;

	@Autowired
	public CountryController2(CountryService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/getAll")
	public ResponseEntity<List<Country>> getAll(){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.getAll());
	}
}
