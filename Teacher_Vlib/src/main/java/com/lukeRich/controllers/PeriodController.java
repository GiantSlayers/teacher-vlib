package com.lukeRich.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lukeRich.models.Period;
import com.lukeRich.repos.PeriodRepo;

@CrossOrigin
@RestController
public class PeriodController {
	
	@Autowired
	private PeriodRepo periodRepository;
	
	@PostMapping("/period")
	public @ResponseBody Period addPeriod(@RequestBody Period p) {
		GregorianCalendar due = new GregorianCalendar();
		
		p.setCheckoutDate(due.getTime());
		
		due.add(Calendar.MONTH, 1);
		
		p.setDueBack(due.getTime());
		
		return periodRepository.save(p);
	}
	
	@GetMapping("/periods")
	public Iterable<Period> getList(){
		return periodRepository.findAll();
	}
}

