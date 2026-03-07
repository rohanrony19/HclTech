package com.springboot.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.profiles.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{
	
}
