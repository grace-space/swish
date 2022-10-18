package com.grace.swish.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grace.swish.model.Library;
import com.grace.swish.service.LibraryService;

@Controller
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	private Library library;
	
//	@ResponseBody
//	@GetMapping("/api/library")
//	public Library findLibraryByUserId(@RequestParam Long userId) {
//		library = libraryService.findLibraryByUserId(userId);
//		return library;
//	}
	
	

}
