package com.grace.swish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	Game findByTitle(String name);
	

}
