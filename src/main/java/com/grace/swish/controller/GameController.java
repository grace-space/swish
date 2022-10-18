package com.grace.swish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grace.swish.model.Game;
import com.grace.swish.service.GameService;

@RestController
@RequestMapping("/api")
public class GameController {

	@Autowired
	GameService gameService;


	/*
	 * finds all games if no criteria, otherwise finds games based on title search and/or field filters
	 */
	@GetMapping("/games")
	public List<Game> findAllGames(@RequestParam(required = false) String title, @RequestParam(required = false) String platform) {
		List<Game> games;
		
		if(title == null && platform == null) {
			games = gameService.findAllGames();
			return games;
		} else if(platform == null) {
			games = gameService.findGamesByTitle(title);
			return games;
		} else if(title == null) {
			games = gameService.findGamesByPlatformName(platform);
			return games;
		} else {
			games = gameService.findGamesByTitleAndPlatform(title, platform);
			return games;
		}
	}
	
	

	@GetMapping("/game/{id}")
	public Optional<Game> findGame(@PathVariable("id") long gameId) {
		Optional<Game> game = gameService.findGameById(gameId);
		return game;
	}
	
	@GetMapping("/platforms/{platformId}/games")
	public List<Game> getAllGamesByPlatformId(@PathVariable(value = "platformId") long platformId) {

		List<Game> games = gameService.getAllGamesByPlatformId(platformId);
		return games;

	}
	
	
	/*
	 * returns all games if no searched title or returns games containing search terms
	 * this has been replaced with the other method that has more criteria
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
