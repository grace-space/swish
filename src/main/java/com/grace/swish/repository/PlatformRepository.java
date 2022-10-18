package com.grace.swish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long>{
	
	Platform findByPlatformName(String platformName);

	// changed to unidirectional so can no longer use this
//	List<Platform> findPlatformsByGamesGameId(Long gameId);
	
}
