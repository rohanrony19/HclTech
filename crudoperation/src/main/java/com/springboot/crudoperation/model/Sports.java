package com.springboot.crudoperation.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sports {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String country;
	
	@Embedded
	private Team team;
	
	private Integer no_of_wins;
	
	private Double win_perc;

	public Sports(Integer id, String country, Team team, Integer no_of_wins, Double win_perc) {
		super();
		this.id = id;
		this.country = country;
		this.team = team;
		this.no_of_wins = no_of_wins;
		this.win_perc = win_perc;
	}

	public Sports() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getNo_of_wins() {
		return no_of_wins;
	}

	public void setNo_of_wins(Integer no_of_wins) {
		this.no_of_wins = no_of_wins;
	}

	public double getWin_perc() {
		return win_perc;
	}

	public void setWin_perc(Double win_perc) {
		this.win_perc = win_perc;
	}

	@Override
	public String toString() {
		return "Sports [id=" + id + ", country=" + country + ", team=" + team + ", no_of_wins=" + no_of_wins
				+ ", win_perc=" + win_perc + "]";
	}
	
	
	
	
}
