package com.grace.swish.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grace.swish.dto.UserDto;
import com.grace.swish.model.Game;
import com.grace.swish.model.User;
import com.grace.swish.repository.UserRepository;
import com.grace.swish.service.GameService;
import com.grace.swish.service.UserService;

import jakarta.validation.Valid;
import lombok.*;

@AllArgsConstructor
@Controller
public class UserController {

	private UserRepository userRepository;

	private UserService userService;

	private GameService gameService;

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {

		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
		User existingEmail = userService.findUserByEmail(userDto.getEmail());
		if (existingEmail != null && existingEmail.getEmail() != null && !existingEmail.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		User existingUsername = userService.findUserByUsername(userDto.getUsername());
		if (existingUsername != null && existingUsername.getUsername() != null
				&& !existingUsername.getUsername().isEmpty()) {
			result.rejectValue("username", null, "This username already exists");
		}

		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/register";
		}

		userService.saveUser(userDto);
		return "redirect:/register?success";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// this one doesn't work at all
//	@PreAuthorize("isAuthenticated()")
//	@GetMapping("/index/addToLibrary")
//	public String updateUserLibraryByGameId(@RequestParam long gameId, Model model) {
//		User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//		Optional<Game> game = gameService.findGameById(gameId);
//		Set<Game> gameLibrary = user.getLibrary();
//		gameLibrary.add(game.get());
//		userRepository.save(user);
//		model.addAttribute("gameLibrary", gameLibrary);
//		model.addAttribute("user", user);
//
//		return "redirect:/index";
//	}

	// testing out to see if i can get user
//	@PreAuthorize("isAuthenticated()")
//	@GetMapping
//	public String currentUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result, Model model) {
//
//		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//		String email = loggedInUser.getName();
//
//		User user = userRepository.findByEmail(email);
//		Long userId = user.getUserId();
//		model.addAttribute("userId", userId);
//		model.addAttribute("emailAddress", email);
//		model.addAttribute("test", "hello world");
//
//		return "index";
//	}


	/*
	 * gets current user's id and adds game to their library
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/addtoLibrary")
	public String updateUserLibraryByGameId(@RequestParam long gameId) {
		User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Optional<Game> game = gameService.findGameById(gameId);
		Set<Game> gameLibrary = user.getLibrary();
		if (!gameLibrary.contains(game.get())) {
			gameLibrary.add(game.get());
			userRepository.save(user);
			return "redirect:/index?successLibrary";
		} else {
			return "redirect:/index?failLibrary";
		}
	}
		
		@PreAuthorize("isAuthenticated()")
		@GetMapping("/removeFromLibrary")
		public String deleteGameFromUserLibraryByGameId(@RequestParam long gameId) {
			User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
			Optional<Game> game = gameService.findGameById(gameId);
			Set<Game> gameLibrary = user.getLibrary();
			if (!gameLibrary.contains(game.get())) {
				gameLibrary.remove(game.get());
				userRepository.save(user);
				return "redirect:/library?successLibrary";
			} else {
				return "redirect:/library?failLibrary";
				
			}

	}

}
