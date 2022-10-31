package com.jeffs.bookClub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	@NotEmpty(message="Must not be blank")
	@Email(message="please enter a valid email")
	private String email;
	@NotEmpty(message="Must not be blank")
	@Size(min=6, max=255, message="Minimum length 6 characters")
	private String password;

	public LoginUser() {
	}

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
	}
	
	
	
}
