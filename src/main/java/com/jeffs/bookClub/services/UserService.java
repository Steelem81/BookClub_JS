package com.jeffs.bookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jeffs.bookClub.models.LoginUser;
import com.jeffs.bookClub.models.User;
import com.jeffs.bookClub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "nonunique", "This email already exists");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "match", "Passwords do not match");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
			return userRepo.save(newUser);
		}
	
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "notFound", "This email could not be found");
		}
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
			result.rejectValue("password", "match", "Invalid Password");
		}
		if(result.hasErrors()){
			return null;
		} else {
			return user;
		}
		
	}
	
	public User getUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else return null;
	}
	
}
