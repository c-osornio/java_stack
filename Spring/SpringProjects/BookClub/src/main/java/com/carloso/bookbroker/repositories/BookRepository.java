package com.carloso.bookbroker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.bookbroker.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	Optional<Book> findById(Long id);
	
	List<Book> findByUserIdIs(Long userId);
	List<Book> findByBorrowerIdIs(Long userId);
	List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerID, Long userId);
}
