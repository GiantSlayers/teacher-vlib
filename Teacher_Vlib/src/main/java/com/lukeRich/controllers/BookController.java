package com.lukeRich.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lukeRich.models.Book;
import com.lukeRich.models.Period;
import com.lukeRich.repos.BooksRepo;
import com.lukeRich.repos.PeriodRepo;

@CrossOrigin
@RestController
public class BookController {
	
	@Autowired
	private BooksRepo bookRepository;
	
	@GetMapping("/books")
	public @ResponseBody Iterable<Book> getBooks() {
		return bookRepository.findAll();
	}
}


