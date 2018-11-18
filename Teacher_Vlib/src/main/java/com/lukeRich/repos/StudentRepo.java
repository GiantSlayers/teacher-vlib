package com.lukeRich.repos;

import org.springframework.data.repository.CrudRepository;

import com.lukeRich.models.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
 
}
