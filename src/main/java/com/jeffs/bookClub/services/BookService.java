package com.jeffs.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffs.bookClub.models.Book;
import com.jeffs.bookClub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
		
	}
	
	public Book getBookById(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		}else {
			return null;
		}
	}

}
