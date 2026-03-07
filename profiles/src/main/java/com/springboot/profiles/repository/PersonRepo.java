package com.springboot.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.profiles.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
