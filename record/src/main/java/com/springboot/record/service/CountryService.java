package com.springboot.record.service;

import java.util.List;


import com.springboot.record.model.Country;
import com.springboot.record.model.CountryDto;


public interface CountryService {

	Country addCountry(CountryDto country);
	
	List<Country> getAll();
	
	Country getById(Long id);
	
}
