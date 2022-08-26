package com.carloso.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.booksapi.models.Book;
import com.carloso.booksapi.repositories.BookRepository;


@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	 // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
    	return bookRepository.findById(id).orElse(null);
    }
    // updates a book
    public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
    // deletes a book
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
}
