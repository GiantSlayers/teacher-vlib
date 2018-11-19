package com.lukeRich.repos;

import org.springframework.data.repository.CrudRepository;

import com.lukeRich.models.Book;

public interface BooksRepo extends CrudRepository<Book, Integer> {
 
}
