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
import com.lukeRich.models.Student;
import com.lukeRich.repos.BooksRepo;
import com.lukeRich.repos.PeriodRepo;
import com.lukeRich.repos.StudentRepo;

@CrossOrigin
@RestController
public class StudentController {
	
	@Autowired
	private StudentRepo studentsRepository;
	
	@GetMapping("/students")
	public @ResponseBody Iterable<Student> getBooks() {
		return studentsRepository.findAll();
	}
}


