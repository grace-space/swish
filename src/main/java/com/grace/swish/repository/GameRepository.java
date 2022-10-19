package com.grace.swish.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Game;



@Repository
public interface GameRepository extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game>, PagingAndSortingRepository<Game, Long> {
	
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
	 * method queries for all field searches
	 */
//	List<Game> findByTitleContainingAndPlatformsPlatformNameAndGenresGenreNameAndFormatsFormatTypeAndRetailersRetailerName(String title, String platformName, String genreName, String formatType, String retailerName);


	List<Game> findByTitleContainingAndPlatformsPlatformName(String title, String platformName);
	List<Game> findByTitleContainingAndFormatsFormatType(String title, String formatType);
	List<Game> findGamesByPlatformsPlatformNameAndFormatsFormatType(String platformName, String formatType);
	List<Game> findByTitleContainingAndPlatformsPlatformNameAndFormatsFormatType(String title, String platformName, String formatType);
	
	// not sure if we need below
	List<Game> findGamesByLibrariesLibraryId(Long libraryId);
	
	// testing library user
//	List<Game> findGamesByLibrariesUsersUserId(Long userId);
//	List<Game> findGamesbyLibrariesByUserUserId(Long userId);
	
	
}
