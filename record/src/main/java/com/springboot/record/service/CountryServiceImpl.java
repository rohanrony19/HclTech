package com.springboot.record.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.record.model.Country;
import com.springboot.record.model.CountryDto;
import com.springboot.record.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	private final CountryRepository repo;
	
	@Autowired
	public CountryServiceImpl(CountryRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Country addCountry(CountryDto country) {
		Country count = new Country();
		count.setName(country.name());
		count.setCapital(country.capital());
		count.setPopulation(country.population());
		return repo.save(count);
	}

	@Override
	public List<Country> getAll() {
		return repo.findAll();
	}

	@Override
	public Country getById(Long id) {
		Country c = repo.findById(id).orElseThrow(()->new RuntimeException());
		return c;
	}

	
}
