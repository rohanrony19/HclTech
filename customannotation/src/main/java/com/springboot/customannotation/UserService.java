package com.springboot.customannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserDto userDto;
	
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserDto userDto, UserRepository userRepository) {
		super();
		this.userDto = userDto;
		this.userRepository = userRepository;
	}

	public User addUser(User user) {
		userDto.setName(user.getName());
		userDto.setAge(user.getAge());
		return userRepository.save(user);
	}
	
}
