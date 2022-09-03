package com.carloso.blotify.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.blotify.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
}
