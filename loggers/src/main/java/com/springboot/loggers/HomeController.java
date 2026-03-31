package com.springboot.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private static final Logger log = LogManager.getLogger(HomeController.class);
	
	@GetMapping("/hello")
	public String hello() {
		log.info("API called");
		log.error("Error example");
		
		return "Hello";
	}
}
