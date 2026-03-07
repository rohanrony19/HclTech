package com.springboot.crudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudoperation.controller.CustomerController;
import com.springboot.crudoperation.model.Sports;
import com.springboot.crudoperation.model.Team;
import com.springboot.crudoperation.repository.SportsRepository;

@Service
public class SportService {

	@Autowired
	private SportsRepository sr;
	
	public void addData(Sports sport) {
		sr.save(sport);
	}
	
	public List<Sports> getData(Sports sport) {
		return sr.findAll();
	}
	
	public Sports updateById(Integer id,Sports update) {
		Sports sp = sr.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to update" + id));
		sp.setCountry(update.getCountry());
		if(sp.getTeam() == null) {
			sp.setTeam(new Team());
		}
		sp.getTeam().setName(update.getTeam().getName());
		sp.getTeam().setStrike_rate(update.getTeam().getStrike_rate());
		sp.getTeam().setType(update.getTeam().getType());
		sp.setWin_perc(update.getWin_perc());
		sp.setNo_of_wins(update.getNo_of_wins());
		sp.setWin_perc(update.getWin_perc());
		return sp;
	}
	
	public List<Sports> getSortByCountry(){
		return sr.sortCountryByPercentage();
	}
}
