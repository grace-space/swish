package com.grace.swish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grace.swish.model.Game;
import com.grace.swish.service.GameService;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/games")
	public List<Game> findAllGames() {
		
		List<Game> games = gameService.findAllGames();
		return games;
		
	}
	
	@GetMapping("/games/{id}")
	public Optional<Game> findGame(@PathVariable("id") long gameId) {
		Optional<Game> game = gameService.findGameById(gameId);
		return game;
	}
	
	@GetMapping("/gamesTitle/{gameTitle}")
	public Game findGameByGameTitle(@PathVariable("gameTitle") String gameTitle) {
		Game game = gameService.findGameByTitle(gameTitle);
		
		return game;
	}
	
	@PostMapping("/games")
	public void createGame(@RequestBody Game game) {
		gameService.addGame(game);
	}
	
	@DeleteMapping("/games/{gameId}")
	public void deleteGame(@PathVariable("gameId") long gameId) {
		gameService.deleteGame(gameId);
	}
	
	@DeleteMapping("/games")
	public void deleteAllGames() {
		gameService.deleteAllGames();
	}

}
