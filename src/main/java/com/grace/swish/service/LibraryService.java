package com.grace.swish.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grace.swish.model.Library;
import com.grace.swish.repository.LibraryRepository;


@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	private Library library;
	
	public Library findLibraryByUserId(long userId) {
		
		library = libraryRepository.findLibraryByUserUserId(userId);
		return library;
		
	}

}
