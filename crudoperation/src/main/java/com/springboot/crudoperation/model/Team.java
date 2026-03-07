package com.springboot.crudoperation.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Team {

	private String name;
	
	private Double strike_rate;
	
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStrike_rate() {
		return strike_rate;
	}

	public void setStrike_rate(Double strike_rate) {
		this.strike_rate = strike_rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Team() {
		super();
	}

	public Team(String name, Double strike_rate, String type) {
		super();
		this.name = name;
		this.strike_rate = strike_rate;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", strike_rate=" + strike_rate + ", type=" + type + "]";
	}
	
	
}
