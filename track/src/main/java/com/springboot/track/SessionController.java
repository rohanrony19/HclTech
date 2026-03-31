package com.springboot.track;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionController {

	@GetMapping("/set")
	public String set(HttpSession session) {
		session.setAttribute("username", "rony" );
		return "session set";
	}
	
	@GetMapping("/get")
	public String getUser(HttpSession session) {
		String user = (String)session.getAttribute("username");
		return user==null?"No session": user;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}
