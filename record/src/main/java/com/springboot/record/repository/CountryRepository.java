package com.springboot.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.record.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
