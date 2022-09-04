package com.carloso.loginandregistration.services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.carloso.loginandregistration.models.LoginUser;
import com.carloso.loginandregistration.models.User;
import com.carloso.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
    public User findById(Long id) {
    	return userRepo.findById(id).orElse(null);
    }
	
	public User register(User newUser, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	// Reject if email is taken (present in database)
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "*An account with that email already exists!");
    	}
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirmPW())) {
    		result.rejectValue("confirmPW", "Matches", "*Passwords do not match!");
    	}
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	// Reject if password does not match regexp 
    	String regExp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,128}$";
    	String password = newUser.getPassword();
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(password);

        if(!matcher.matches()) {
        	result.rejectValue("password", "Matches", "*Passwords must contain at least 1 digit, lowercase letter, uppercase letter, and special character.");
        	return null;
        }
        
        // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    	
    }

    public User login(LoginUser newLogin, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    	// Find user in the DB by email
        // Reject if NOT present
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "*Invalid Email!");
    		return null;
    	}
    	// User exists, retrieve user from DB
    	User user = potentialUser.get();
        // Reject if BCrypt password match fails
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "*Invalid Password!");
    	}
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
        // Otherwise, return the user object
        return user;
    }
}
