package com.springboot.crudoperation.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
public class Company {
	
	private String name;
	private String domain;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Company() {
		
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", domain=" + domain + "]";
	}
	public Company(String name, String domain) {
		super();
		this.name = name;
		this.domain = domain;
	}
	
}
