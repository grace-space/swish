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
		Platform platform1 = new Platform();
		platform1.setPlatformName("Nintendo Switch");

		Platform platform2 = new Platform();
		platform2.setPlatformName("PC");

		platformRepository.save(platform1);
		platformRepository.save(platform2);

		Game game1 = new Game();
		game1.setTitle("Mario");
		game1.setRating(8);
		game1.setMsrp(59.99);
		game1.setImgUrl("http");
		game1.setPlatforms(Set.of(platform1));
		game1.setDescription(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl condimentum id venenatis a condimentum vitae sapien pellentesque. Vulputate ut pharetra sit amet. Felis eget nunc lobortis mattis aliquam. Rhoncus mattis rhoncus urna neque viverra justo. Ultrices sagittis orci a scelerisque. Libero nunc consequat interdum varius sit amet. Mauris nunc congue nisi vitae suscipit tellus. Consequat id porta nibh venenatis cras sed felis. Enim nulla aliquet porttitor lacus luctus accumsan. Vitae et leo duis ut diam. Turpis in eu mi bibendum neque egestas congue quisque. Quis lectus nulla at volutpat.");

		Game game2 = new Game();
		game2.setTitle("Call of Duty");
		game2.setRating(9);
		game2.setMsrp(59.99);
		game2.setImgUrl("http");
		game2.setPlatforms(Set.of(platform2));
		game2.setDescription(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl condimentum id venenatis a condimentum vitae sapien pellentesque. Vulputate ut pharetra sit amet. Felis eget nunc lobortis mattis aliquam. Rhoncus mattis rhoncus urna neque viverra justo. Ultrices sagittis orci a scelerisque. Libero nunc consequat interdum varius sit amet. Mauris nunc congue nisi vitae suscipit tellus. Consequat id porta nibh venenatis cras sed felis. Enim nulla aliquet porttitor lacus luctus accumsan. Vitae et leo duis ut diam. Turpis in eu mi bibendum neque egestas congue quisque. Quis lectus nulla at volutpat.");


		gameRepository.save(game1);
		gameRepository.save(game2);

	}

}