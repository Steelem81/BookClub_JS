package com.jeffs.bookClub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeffs.bookClub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	//Find all Books
	List<Book> findAll();
	//Find Book by id
	Optional<Book> findById(Long search);

}
