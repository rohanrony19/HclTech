package com.springboot.finclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	PostService postService;
	
	@GetMapping("/get")
	public String posts() {
		return postService.getPost();
	}
}
