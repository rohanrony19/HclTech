package com.springboot.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class GenerateJwtToken {

	private final String secret = "asdfghjklqwertyuiopzxc#vbn2345tgb";
	
	public Key getKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()*60*60))
				.signWith(getKey(),SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String extractUserNameFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJwt(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validate(String username,String token) {
		return extractUserNameFromToken(token)
				.equals(username);
	}
}
