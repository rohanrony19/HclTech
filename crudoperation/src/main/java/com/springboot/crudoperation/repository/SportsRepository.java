package com.springboot.crudoperation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.crudoperation.model.Sports;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Integer>{
	
	@Query("select s FROM Sports s ORDER BY s.win_perc DESC")
	public List<Sports> sortCountryByPercentage();
}
