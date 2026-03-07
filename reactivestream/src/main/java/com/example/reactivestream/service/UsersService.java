package com.example.reactivestream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reactivestream.model.Users;
import com.example.reactivestream.repository.UsersRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsersService {

	private final UsersRepository usersRepository;

	@Autowired
	public UsersService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}
	
	public Flux<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	public Mono<Users> getUser(Long id){
		return usersRepository.findById(id);
	}
	
	public Mono<Users> saveUser(Users users){
		return usersRepository.save(users);
	}
	
}
