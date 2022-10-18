package com.grace.swish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grace.swish.dto.UserDto;
import com.grace.swish.model.User;
import com.grace.swish.repository.UserRepository;

import lombok.*;

@AllArgsConstructor
@Service
public class UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public void saveUser(UserDto userDto) {
		User user = new User();
		
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(user);

	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
//	private UserDto mapToUserDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setUsername(user.getUsername());
//		userDto.setEmail(user.getEmail());
//		return userDto;
//	}

}
