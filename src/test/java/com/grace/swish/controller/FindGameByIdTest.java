package com.grace.swish.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grace.swish.model.Game;
import com.grace.swish.repository.GameRepository;

import jakarta.annotation.Resource;

@SpringBootTest
public class FindGameByIdTest {
	
	@Resource
	private GameRepository gameRepository;
	
	@Test
	public void test(Long gameId) {
		Game expectedGame = new Game(1, "Mario", 8, 59.99, "http", "Description", null, null, null, null, null, null, null);
		Optional<Game> actualGame = gameRepository.findById(gameId);
		assertEquals(expectedGame, actualGame);
		}
	

}
