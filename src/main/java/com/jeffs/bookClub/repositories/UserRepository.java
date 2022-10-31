package com.jeffs.bookClub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeffs.bookClub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	//Find User by Id
	Optional<User> findById(Long search);
	
	//Find User by Email
	Optional<User> findByEmail(String search);

}
