package com.carloso.blotify.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.carloso.blotify.models.LoginUser;
import com.carloso.blotify.models.User;
import com.carloso.blotify.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User register(User newUser, BindingResult results) {
		if (newUser.getPassword().equals(newUser.getConfirmPW())) {
			// Hash Password
			newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
			// Store in DB and return newUser
			return userRepo.save(newUser);
		} else {
			results.rejectValue("confirmPW", "Matches", "Passwords do not match.");
			return null;
		}
	}
	
    public User findUserById(Long id) {
    	return userRepo.findById(id).orElse(null);
    }
    
    public User findUserByEmail(LoginUser loginUser, BindingResult results) {
    	Optional<User> user = userRepo.findByEmail(loginUser.getEmail());
    	if (user.isPresent()) {
    		if (BCrypt.checkpw(loginUser.getPassword(), user.get().getPassword())) {
    			return user.get();
    	   	} else {
        		results.rejectValue("email", "login", "Invalid Username/Password.");
        		return null;
    		}
    	} else {
    		results.rejectValue("email", "login", "Invalid Username/Password.");
    		return null;
    	}
    }

}
