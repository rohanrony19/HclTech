package com.springboot.finclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo",url = "http://jsonplaceholder.typicode.com")
public interface DemoClient {
	
	@GetMapping("/posts/1")
	String getPost();

}
