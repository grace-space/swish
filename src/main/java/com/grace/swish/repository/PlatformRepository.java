package com.grace.swish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long>{
	
	Platform findByPlatformName(String platformName);

}
