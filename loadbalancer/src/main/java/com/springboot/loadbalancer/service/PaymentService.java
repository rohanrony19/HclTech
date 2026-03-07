package com.springboot.loadbalancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.loadbalancer.dto.PaymentDto;
import com.springboot.loadbalancer.exception.IdNotFound;
import com.springboot.loadbalancer.model.Payment;
import com.springboot.loadbalancer.model.PaymentMapper;
import com.springboot.loadbalancer.repository.PaymentRepo;

@Service
public class PaymentService {

	private final PaymentRepo paymentRepo;
	
	@Autowired
	public PaymentService(PaymentRepo paymentRepo) {
		super();
		this.paymentRepo = paymentRepo;
	}

	public PaymentDto save(PaymentDto dto) {
		Payment entity = PaymentMapper.toEntity(dto);
		Payment p = paymentRepo.save(entity);
		return PaymentMapper.toDto(p);
	}
	
	public PaymentDto findById(Long id) {
		Payment prod = paymentRepo.findById(id).orElseThrow(()->new IdNotFound("Id Not Found"));
		return PaymentMapper.toDto(prod);
	}
	
	public List<PaymentDto> findAll() {
		return paymentRepo.findAll()
        .stream()
        .map(PaymentMapper::toDto)
        .toList();
	}
}
