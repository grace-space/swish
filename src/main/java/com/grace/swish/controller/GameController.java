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
import com.grace.swish.model.Platform;
import com.grace.swish.service.GameService;

@Controller
@RequestMapping("/api")
public class GameController {

	@Autowired
	GameService gameService;

	@ResponseBody
	@GetMapping("/games")
	public List<Game> findAllGames() {

		List<Game> games = gameService.findAllGames();
		return games;

	}

	// to edit later -- if i want to add some search function for
	// findTitleContaining ...
//	@ResponseBody
//	@GetMapping("/games")
//	public List<Game> findAllGames(@RequestParam(required = false) String title) {
//		
//		if(title == null) {
//			List<Game> games = gameService.findAllGames();
//		} else {
	
//		}
//		return games;
//		
//	}

	@ResponseBody
	@GetMapping("/games/{id}")
	public Optional<Game> findGame(@PathVariable("id") long gameId) {
		Optional<Game> game = gameService.findGameById(gameId);
		return game;
	}

	@ResponseBody
	@GetMapping("/gamesTitle/{gameTitle}")
	public Game findGameByGameTitle(@PathVariable("gameTitle") String gameTitle) {
		Game game = gameService.findGameByTitle(gameTitle);

		return game;
	}

	// trying out requestparam
//	@GetMapping("/games1")
//	public Game findGameByGameTitle(@RequestParam String title) {
//		Game game = gameService.findGameByTitle(title);
//		
//		return game;
//	}

	@ResponseBody
	@PostMapping("/games")
	public void createGame(@RequestBody Game game) {
		gameService.addGame(game);
	}

	@ResponseBody
	@DeleteMapping("/games/{gameId}")
	public void deleteGame(@PathVariable("gameId") long gameId) {
		gameService.deleteGame(gameId);
	}

	@ResponseBody
	@DeleteMapping("/games")
	public void deleteAllGames() {
		gameService.deleteAllGames();
	}

}
