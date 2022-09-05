package com.carloso.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.bookclub.models.Book;
import com.carloso.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
    public Book findBook(Long id) {
    	return bookRepo.findById(id).orElse(null);
    }
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	 
    public void updateBook(Book b) {
    	bookRepo.save(b);
    }
    
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }

}
