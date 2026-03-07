package com.springboot.jwt.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@GetMapping("/hello")
    public String hello(Authentication auth) {
        return "Hello, " + (auth != null ? auth.getName() : "anonymous");
    }

}
