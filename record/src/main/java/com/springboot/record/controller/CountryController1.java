package com.springboot.record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.record.model.Country;
import com.springboot.record.model.CountryDto;
import com.springboot.record.service.CountryService;

@RestController
public class CountryController1 {

	private final CountryService service;

	@Autowired
	public CountryController1(CountryService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Country> addCountry(@RequestBody CountryDto dto){
		Country c = service.addCountry(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	
}
