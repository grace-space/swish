package com.grace.swish;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.grace.swish.model.Game;
import com.grace.swish.model.Platform;
import com.grace.swish.repository.GameRepository;
import com.grace.swish.repository.PlatformRepository;

@SpringBootApplication
public class SwishApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwishApplication.class, args);

	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private PlatformRepository platformRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Platform platform = new Platform();
		platform.setPlatformName("PlayStation");
		
		Platform platform2 = new Platform();
		platform2.setPlatformName("Xbox");
		
		Platform platform3 = new Platform();
		platform3.setPlatformName("PC");
		
		platformRepository.save(platform);
		platformRepository.save(platform2);
		platformRepository.save(platform3);
		
		Game game = new Game();
		game.setTitle("Mario");
		game.setRating(8);
		game.setMsrp(59.99);
		game.setImgUrl("http");
		game.setPlatforms(Set.of(platform));
		
		gameRepository.save(game);
		
		
		
	}
	
	

}