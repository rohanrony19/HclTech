package com.springboot.record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.record.model.Country;
import com.springboot.record.service.CountryService;

@RestController
public class CountryController3 {

	private final CountryService service;

	@Autowired
	public CountryController3(CountryService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/getById")
	public ResponseEntity<Country> addCountry(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.getById(id));
	}
}
