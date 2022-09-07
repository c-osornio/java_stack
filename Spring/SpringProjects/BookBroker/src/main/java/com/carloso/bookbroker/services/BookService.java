package com.carloso.bookbroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.bookbroker.models.Book;
import com.carloso.bookbroker.models.User;
import com.carloso.bookbroker.repositories.BookRepository;

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

	public List<Book> availableBooks(){
		return bookRepo.findByBorrowerIdIs(null);
	}
	
	public List<Book> borrowedBooks(User user){
		return bookRepo.findByBorrowerIdIs(user.getId());
	}
	
	public List<Book> userBooks(User user){
		return bookRepo.findByUserIdIs(user.getId());
	}
	
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}
}
