package com.grace.swish.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grace.swish.dto.UserDto;
import com.grace.swish.model.Game;
import com.grace.swish.model.User;
import com.grace.swish.repository.UserRepository;

import lombok.*;

@AllArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private GameService gameService;
	

	public void saveUser(UserDto userDto) {
		User user = new User();
		
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(user);

	}
	
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	/*
	 * checks the login ID (email) of currently signed in user and adds game to their library
	 */
	public User updateUserLibraryByGameId(Long gameId) {
		User user = findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Optional<Game> game = gameService.findGameById(gameId);
		Set<Game> gameLibrary = user.getLibrary();
		gameLibrary.add(game.get());
		userRepository.save(user);
		return user;
	}
	
//	private UserDto mapToUserDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setUsername(user.getUsername());
//		userDto.setEmail(user.getEmail());
//		return userDto;
//	}

}
