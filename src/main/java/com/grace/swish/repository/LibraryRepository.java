package com.grace.swish.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{
	
//	Set<Library> findAllByUserId(long userId);

}
