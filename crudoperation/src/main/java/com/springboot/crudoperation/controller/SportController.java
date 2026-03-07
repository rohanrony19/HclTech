package com.springboot.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudoperation.model.Sports;
import com.springboot.crudoperation.service.SportService;

@RestController
public class SportController {

	@Autowired
	SportService sportService;
	
	@PostMapping("/add")
	public String addData(@RequestBody  Sports s){
		 sportService.addData(s);
		 return "saved";
	}
	
	@GetMapping("/sort")
	public List<Sports> listOfSports(){
		return sportService.getSortByCountry();
	}
}
