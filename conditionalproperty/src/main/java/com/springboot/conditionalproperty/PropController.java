package com.springboot.conditionalproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropController {

	private final MessageServices msg;
	
	@Autowired
	public PropController(MessageServices msg) {
		this.msg=msg;
	}
	
	@GetMapping("/get")
	public String f1() {
		msg.msg();
		return "x";
	}
}
