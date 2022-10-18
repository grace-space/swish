package com.grace.swish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grace.swish.dto.UserDto;
import com.grace.swish.model.User;
import com.grace.swish.service.UserService;

import jakarta.validation.Valid;
import lombok.*;

@AllArgsConstructor
@Controller
public class UserController {
	
	private UserService userService;
	
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
		if (existingUsername != null && existingUsername.getUsername() != null && !existingUsername.getUsername().isEmpty()) {
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
	
	

}
