package com.grace.swish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grace.swish.model.Game;
import com.grace.swish.model.Platform;
import com.grace.swish.service.PlatformService;

@Controller
@RequestMapping("/api")
public class PlatformController {
	
	@Autowired
	PlatformService platformService;
	
	@ResponseBody
	@GetMapping("/platforms")
	public List<Platform> findAllPlatforms() {
		
		List<Platform> platforms = platformService.findAllPlatforms();
		return platforms;
		
	}
	
	@ResponseBody
	@GetMapping("/platforms/{id}")
	public Optional<Platform> findPlatform(@PathVariable("id") long platformId) {
		Optional<Platform> platform = platformService.findPlatformById(platformId);
		return platform;
	}
	
	@ResponseBody
	@GetMapping("/platforms/{platformId}/games")
	public List<Game> getAllGamesByPlatformId(@PathVariable(value = "platformId") long platformId) {
		
		List<Game> games = platformService.getAllGamesByPlatformId(platformId);
		return games;
		
		
	}
	

	@PostMapping ("/platforms/")
	public Platform addPlatform(@RequestBody Platform platform) {

	   return platformService.addPlatform(platform);

	}
	

	
	

}
