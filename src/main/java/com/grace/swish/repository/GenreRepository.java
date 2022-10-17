package com.grace.swish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
	
	Genre findByGenreName(String genreName);

}
