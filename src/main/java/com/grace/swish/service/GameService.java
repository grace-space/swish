package com.grace.swish.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grace.swish.model.Game;
import com.grace.swish.model.Platform;
import com.grace.swish.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public List<Game> findAllGames() {

		List<Game> games = new ArrayList<Game>();
		gameRepository.findAll().forEach(games::add);
		return games;

	}
	
	public Optional<Game> findGameById(long gameId) {
		return gameRepository.findById(gameId);
		
	}
	
	// not sure why this does not have Optional
	public Game findGameByTitle(String title) {
		return gameRepository.findByTitle(title);
		
	}

	
	public void addGame(Game game) {
		gameRepository.save(game);
	}
	
	// not sure if i need this method right now
//	public void updateGame(long gameId, Game game) {
//		Optional<Game> gameData = gameRepository.findById(gameId);
//		
//		if (gameData.isPresent()) {
//			Game game2 = gameData.get();
//			game2.setTitle(game.getTitle());
//			game2.setRating(game.getRating());
//			game2.setMsrp(game.getMsrp());
//			game2.setImgUrl(game.getImgUrl());
//			game2.setGenres(game.getGenres());
//			game2.setPlatforms(game.getPlatforms());
//			game2.setFormats(game.getFormats());
//			game2.setRetailers(game.getRetailers());
//			gameRepository.save(game2);
//		}
//	}
	
	public void deleteGame(long gameId) {
		gameRepository.deleteById(gameId);
	}
	
	public void deleteAllGames() {
		gameRepository.deleteAll();
	}

}
