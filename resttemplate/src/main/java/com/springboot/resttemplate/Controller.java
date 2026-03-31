package com.springboot.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Controller {

	private final RestTemplate restTemplate;

	private final ProductService service;
	
	@Autowired
	public Controller(RestTemplate restTemplate,ProductService service) {
		super();
		this.restTemplate = restTemplate;
		this.service = service;
	}
	
	@GetMapping("/getProductById/{id}")
	public Product getById(@PathVariable("id") Integer id) {
		
		String url = "http://localhost:8085/products/find/" + id;
		
		return restTemplate.getForObject(url, Product.class);
	}
	
	@PostMapping("/save")
	public Product save(@RequestBody Product prod) {
		return service.save(prod);
	}
}
