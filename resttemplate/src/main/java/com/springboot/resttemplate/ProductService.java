package com.springboot.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;
	
	public Product save(Product prod) {
		
		String url = "http://localhost:8085/products/save";
		
		return restTemplate.postForObject(url,prod,Product.class);
	}
}
