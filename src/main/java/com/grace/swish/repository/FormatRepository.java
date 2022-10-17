package com.grace.swish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long>{
	
	Format findByFormatType(String formatName);
	

}
