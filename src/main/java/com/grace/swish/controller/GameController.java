package com.grace.swish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grace.swish.dto.UserDto;
import com.grace.swish.model.Game;
import com.grace.swish.model.User;
import com.grace.swish.repository.UserRepository;
import com.grace.swish.service.GameService;
import com.grace.swish.util.ImageUtil;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private UserRepository userRepository;

	private List<Game> games;

	/*
	 * JSON data for a single user's game collection
	 */
	@ResponseBody
	@GetMapping("/api/library")
	public List<Game> findAllLibraryGamesByUserId(@RequestParam long userId) {
		games = gameService.findLibraryGamesbyUserId(userId);
		return games;
	}
	
	/*
	 * JSON data for a single user's wishlist
	 */
	@ResponseBody
	@GetMapping("/api/wishlist")
	public List<Game> findAllWishlistGamesByUserId(@RequestParam long userId) {
		games = gameService.findWishlistGamesbyUserId(userId);
		return games;
	}
	
	/*
	 * redirects to login if no user found
	 */
	@GetMapping("/user/library/")
	public String redirectLogin() {
		return "login";
	}
	
	/*
	 * finds library by user and also creates a custom message to the user
	 */
	@PreAuthorize("isAuthenticated()")
//	@PreAuthorize("authentication.principal.id == #id")
	@GetMapping("/user/library/{userId}")
	public String findLibraryGamesByUserId(@PathVariable Long userId, Model model) {
		games = gameService.findLibraryGamesbyUserId(userId);
		model.addAttribute("libraryGames", games);
		
		Optional<User> user = userRepository.findById(userId);
		String username = user.get().getUsername();
		model.addAttribute("message", username + "'s profile");
		
		return "library";
	}
	
	
	/*
	 * finds wishlist by user
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/user/wishlist/{userId}")
	public String findWishlistGamesByUserId(@PathVariable long userId, Model model) {
		games = gameService.findWishlistGamesbyUserId(userId);
		model.addAttribute("wishlistGames", games);
		
		Optional<User> user = userRepository.findById(userId);
		String username = user.get().getUsername();
		model.addAttribute("message", username + "'s profile");
		
		return "wishlist";
	}
	
	
	/*
	 * to get individual game information to be displayed on the 'game' page
	 */
	@GetMapping("/game/{gameId}")
	public String findGame(@PathVariable("gameId") long gameId, Model model) {
		Optional<Game> game = gameService.findGameById(gameId);
		if (game.isPresent()) {
			model.addAttribute(game.get());
			System.out.print(game.get().getGenres());
			return "game";
		}
		
		return "redirect:/index";

	}

	
	/*
	 * This authenticates a user login to ensure they can get to their profile, and also 
	 * provides multiple search/filter options for games.
	 * I hope to improve a better filter with JpaSpecificationExecutor.
	 */
	@GetMapping("/index")
	public String findGames(@ModelAttribute("user") @RequestParam(required = false, value="title") String title,
			@RequestParam(required = false) String platform, 
			@RequestParam(required = false) String format, @Valid UserDto userDto, BindingResult result,
			Model model) {
		
		if (title == null && platform == null && format == null) {
			games = gameService.findAllGames();
			model.addAttribute("gameList", games);
		} else if (platform == null && format == null) {
			games = gameService.findGamesByTitle(title);
			model.addAttribute("gameList", games);
		} else if (title == null & format == null) {
			games = gameService.findGamesByPlatform(platform);
			model.addAttribute("gameList", games);
		} else if (title == null && platform == null) {
			games = gameService.findGamesByFormat(format);
			model.addAttribute("gameList", games);
		} else if (platform == null) {
			games = gameService.findGamesByTitleAndFormat(title, format);
			model.addAttribute("gameList", games);
		} else if (title == null) {
			games = gameService.findGamesByPlatformAndFormat(platform, format);
			model.addAttribute("gameList", games);
		} else if (format == null) {
			games = gameService.findGamesByTitleAndPlatform(title, platform);
			model.addAttribute("gameList", games);
		} else {
			games = gameService.findGamesByTitlePlatformAndFormat(title, platform, format);
			model.addAttribute("gameList", games);
		}
		model.addAttribute("imgUtil", new ImageUtil());
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String email = loggedInUser.getName();
			User user = userRepository.findByEmail(email);
		if (user != null) {
			Long userId = user.getUserId();
			String username = user.getUsername();
			model.addAttribute("userId", userId);
			model.addAttribute("username", username);
		}
		return "index";
		
	}

	/*
	 * finds all games if no criteria, otherwise finds games based on params
	 * I hope to update to a better filtering in the future with something like
	 * JpaSpecificationExecutor.
	 */
	@ResponseBody
	@GetMapping("/api/games")
	public List<Game> findAllGames(@RequestParam(required = false) String title,
			@RequestParam(required = false) String platform, 
			@RequestParam(required = false) String format) {
		
		if (title == null && platform == null && format == null) {
			games = gameService.findAllGames();
			return games;
		} else if (platform == null && format == null) {
			games = gameService.findGamesByTitle(title);
			return games;
		} else if (title == null & format == null) {
			games = gameService.findGamesByPlatform(platform);
			return games;
		} else if (title == null && platform == null) {
			games = gameService.findGamesByFormat(format);
			return games;
		} else if (platform == null) {
			games = gameService.findGamesByTitleAndFormat(title, format);
			return games;
		} else if (title == null) {
			games = gameService.findGamesByPlatformAndFormat(platform, format);
			return games;
		} else if (format == null) {
			games = gameService.findGamesByTitleAndPlatform(title, platform);
			return games;
		} else {
			games = gameService.findGamesByTitlePlatformAndFormat(title, platform, format);
			return games;
		}
	}
	

	@ResponseBody
	@GetMapping("/platforms/{platformId}/games")
	public List<Game> getAllGamesByPlatformId(@PathVariable(value = "platformId") long platformId) {
		games = gameService.getAllGamesByPlatformId(platformId);
		return games;

	}
	
}
