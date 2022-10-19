package com.grace.swish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import com.grace.swish.model.Game;
import com.grace.swish.service.GameService;

@Controller
//@RequestMapping("/api")
public class GameController {

	@Autowired
	private GameService gameService;

	private List<Game> games;
	

	@ResponseBody
	@GetMapping("/api/library")
	public List<Game> findAllLibraryGamesByUserId(@RequestParam long userId) {
		games = gameService.findLibraryGamesbyUserId(userId);
		return games;
	}
	
	@ResponseBody
	@GetMapping("/api/wishlist")
	public List<Game> findAllWishlistGamesByUserId(@RequestParam long userId) {
		games = gameService.findWishlistGamesbyUserId(userId);
		return games;
	}
	
	@GetMapping("/user/library/{userId}")
	public String findLibraryGamesByUserId(@PathVariable long userId, Model model) {
		games = gameService.findLibraryGamesbyUserId(userId);
		model.addAttribute("libraryGames", games);
		return "library";
	}
	
	@GetMapping("/user/wishlist/{userId}")
	public String findWishlistGamesByUserId(@PathVariable long userId, Model model) {
		games = gameService.findWishlistGamesbyUserId(userId);
		model.addAttribute("wishlistGames", games);
		return "wishlist";
	}

	/*
	 * finds all games if no criteria, otherwise finds games based on params
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
	
	@GetMapping("/index")
	public String findGames(@RequestParam(required = false) String title,
			@RequestParam(required = false) String platform, 
			@RequestParam(required = false) String format,
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
		
		return "index";
		
		
		
	}

	@ResponseBody
	@GetMapping("/game/{id}")
	public Optional<Game> findGame(@PathVariable("id") long gameId) {
		Optional<Game> game = gameService.findGameById(gameId);
		return game;
	}

	@ResponseBody
	@GetMapping("/platforms/{platformId}/games")
	public List<Game> getAllGamesByPlatformId(@PathVariable(value = "platformId") long platformId) {
		games = gameService.getAllGamesByPlatformId(platformId);
		return games;

	}
	
	/*
	 * finds all games if no criteria, otherwise finds games based on title search
	 * and/or field filters
	 */
//	@ResponseBody
//	@GetMapping("/games")
//	public List<Game> findAllGames(@RequestParam(required = false) String title,
//			@RequestParam(required = false) String platform) {
//
//		if (title == null && platform == null) {
//			games = gameService.findAllGames();
//			return games;
//		} else if (platform == null) {
//			games = gameService.findGamesByTitle(title);
//			return games;
//		} else if (title == null) {
//			games = gameService.findGamesByPlatform(platform);
//			return games;
//		} else {
//			games = gameService.findGamesByTitleAndPlatform(title, platform);
//			return games;
//		}
//	}

	/*
	 * returns all games if no searched title or returns games containing search
	 * terms this has been replaced with the other method that has more criteria
	 */
//	@GetMapping("/games")
//	public List<Game> findGames(@RequestParam(required = false) String title) {
//		List<Game> games;
//		
//		if(title == null) {
//			games = gameService.findAllGames();
//			return games;
//		} else {
//			games = gameService.findGamesByTitle(title);
//			return games;
//		}
//		
//	}

//	@GetMapping("/game")
//	public List<Game> findGamesByPlatform(@RequestParam(required = false) String platform) {
//		List<Game> games;
//		
//		if(platform == null) {
//			games = gameService.findAllGames();
//			return games;
//		} else {
//			games = gameService.findGamesByPlatformName(platform);
//			return games;
//		}
//	}

//	@GetMapping("/gameTitle/{gameTitle}")
//	public Game findGameByGameTitle(@PathVariable("gameTitle") String gameTitle) {
//		Game game = gameService.findGameByTitle(gameTitle);
//
//		return game;
//	}

//	@PostMapping("/games")
//	public void createGame(@RequestBody Game game) {
//		gameService.addGame(game);
//	}

//	@DeleteMapping("/games/{gameId}")
//	public void deleteGame(@PathVariable("gameId") long gameId) {
//		gameService.deleteGame(gameId);
//	}

//	@ResponseBody
//	@DeleteMapping("/games")
//	public void deleteAllGames() {
//		gameService.deleteAllGames();
//	}

}
