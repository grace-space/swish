package com.grace.swish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grace.swish.repository.GameRepository;

@Service
public class PlatformService {
	
	@Autowired
	private GameRepository gameRepository;
	

}
