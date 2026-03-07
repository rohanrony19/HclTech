package com.springboot.loadbalancer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.loadbalancer.dto.PaymentDto;
import com.springboot.loadbalancer.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<PaymentDto> save(@RequestBody PaymentDto dto){
		PaymentDto d = paymentService.save(dto);
		System.out.println(d.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(d);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<PaymentDto> getById(@PathVariable("id") Long id){
		PaymentDto d = paymentService.findById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(d);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PaymentDto>> getAll(){
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.findAll());
	}
}
