package com.example.reactivestream.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.reactivestream.model.Users;

public interface UsersRepository extends ReactiveCrudRepository<Users, Long>{

}
