package com.grace.swish.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grace.swish.model.Platform;
import com.grace.swish.repository.PlatformRepository;

@Service
public class PlatformService {

	@Autowired
	private PlatformRepository platformRepository;

	public List<Platform> findAllPlatforms() {

		List<Platform> platforms = new ArrayList<Platform>();
		platformRepository.findAll().forEach(platforms::add);
		return platforms;

	}

	public Optional<Platform> findPlatformById(long platformId) {
		return platformRepository.findById(platformId);
	}

	public Platform findPlatformByName(String platformName) {
		return platformRepository.findByPlatformName(platformName);
	}

//	public Platform addPlatform(Platform platform) {
//		return platformRepository.save(platform);
//	}

}
