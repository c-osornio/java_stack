package com.carloso.blotify.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginUser {
	
	@Email
	@NotNull
	private String email;
	
	
	@NotNull
	private String password;
	
	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};
	
	
	

}
