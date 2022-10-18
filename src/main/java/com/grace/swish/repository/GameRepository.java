package com.grace.swish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
//	Game findByTitle(String name);
	
	/*
	 * method queries by single fields
	 */
	List<Game> findByTitleContaining(String title);
	
	List<Game> findGamesByPlatformsPlatformId(Long platformId);
	
	List<Game> findGamesByPlatformsPlatformName(String platformName);
	
	List<Game> findGamesByGenresGenreName(String genreName);
	
	List<Game> findGamesByFormatsFormatType(String formatType);
	
	List<Game> findGamesByRetailersRetailerName(String retailerName);
	
	/*
	 * method queries for combination searches
	 */
	List<Game> findByTitleContainingAndPlatformsPlatformName(String title, String platformName);
	List<Game> findByTitleContainingAndPlatformsPlatformNameAndGenresGenreName(String title, String platformName, String genreName);
	List<Game> findByTitleContainingAndPlatformsPlatformNameAndGenresGenreNameAndFormatsFormatType(String title, String platformName, String genreName, String formatType);
	List<Game> findByTitleContainingAndPlatformsPlatformNameAndGenresGenreNameAndFormatsFormatTypeAndRetailersRetailerName(String title, String platformName, String genreName, String formatType, String retailerName);

}
