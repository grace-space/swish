package com.grace.swish.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.grace.swish.model.Game;
import com.grace.swish.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	private List<Game> games;
	
	
	public List<Game> findAllGames() {

		games = gameRepository.findAll();
		return games;

	}
	
	public Optional<Game> findGameById(long gameId) {
//		return gameRepository.findById(gameId);
		Optional<Game> game = gameRepository.findById(gameId);
//		System.out.print(game.get());
		return game;

	}
	
	public void deleteGame(long gameId) {
		gameRepository.deleteById(gameId);
	}
	

	/*
	 * looks up userId and returns all games in the user's library
	 */
	public List<Game> findLibraryGamesbyUserId(long userId) {
		games = gameRepository.findAllByLibraryUsersUserId(userId);
		return games;
	}
	
	/*
	 * looks up userId and returns all games in the user's wishlist
	 */
	public List<Game> findWishlistGamesbyUserId(long userId) {
		games = gameRepository.findAllByWishlistUsersUserId(userId);
		return games;
	}
	
	public List<Game> findGamesByTitle(String title) {
		
		games = gameRepository.findByTitleContaining(title);
			return games;
		
	}
	
	public List<Game> getAllGamesByPlatformId(long platformId) {
		games = gameRepository.findGamesByPlatformsPlatformId(platformId);
		return games;

	}
	
	public List<Game> findGamesByPlatform(String platformName) {
		games = gameRepository.findGamesByPlatformsPlatformName(platformName);
		return games;
	}
	
	public List<Game> findGamesByGenre(String genreName) {
		games = gameRepository.findGamesByGenresGenreName(genreName);
		return games;
	}
	
	public List<Game> findGamesByFormat(String formatType) {
		games = gameRepository.findGamesByFormatsFormatType(formatType);
		return games;
	}
	
	public List<Game> findGamesByRetailer(String retailerName) {
		games = gameRepository.findGamesByRetailersRetailerName(retailerName);
		return games;
	}
	
	public List<Game> findGamesByTitleAndPlatform(String title, String platformName) {
		games = gameRepository.findByTitleContainingAndPlatformsPlatformName(title, platformName);
		return games;
	}
	
	public List<Game> findGamesByTitleAndFormat(String title, String formatName) {
		games = gameRepository.findByTitleContainingAndFormatsFormatType(title, formatName);
		return games;
	}
	
	public List<Game> findGamesByPlatformAndFormat(String platformName, String formatType) {
		games = gameRepository.findGamesByPlatformsPlatformNameAndFormatsFormatType(platformName, formatType);
		return games;
	}
	
	public List<Game> findGamesByTitlePlatformAndFormat(String title, String platformName, String formatType) {
		games = gameRepository.findByTitleContainingAndPlatformsPlatformNameAndFormatsFormatType(title, platformName, formatType);
		return games;
	}
	
//	public List<Game> findGamesByTitleAndPlatformAndGenreAndFormatAndRetailer(String title, String platformName, String genreName, String formatType, String retailerName) {
//		games = gameRepository.findByTitleContainingAndPlatformsPlatformNameAndGenresGenreNameAndFormatsFormatTypeAndRetailersRetailerName(title, platformName, genreName, formatType, retailerName);
//		return games;
//	}


//	public void addGame(Game game) {
//		gameRepository.save(game);
//	}


//	public void deleteAllGames() {
//		gameRepository.deleteAll();
//	}

}
