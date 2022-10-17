package com.grace.swish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Multiplayer;

@Repository
public interface MultiplayerRepository extends JpaRepository<Multiplayer, Long>{
	
	Multiplayer findByMultiplayerType(String mutliplayerType);

}
