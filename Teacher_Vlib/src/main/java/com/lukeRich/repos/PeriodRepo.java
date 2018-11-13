package com.lukeRich.repos;

import org.springframework.data.repository.CrudRepository;

import com.lukeRich.models.Period;

public interface PeriodRepo extends CrudRepository<Period, Integer> {

}
