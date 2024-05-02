package com.userprofile.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.userprofile.model.UserRequest;

public interface UserServiceInterface {

	// add user
	// read user
	// read all users
	// update user
	// delete user
	// calculate age
	// validate mobile number

	abstract ResponseEntity<?> createUser(UserRequest userRequest);

	abstract ResponseEntity<?> readUser(String userEmail);

	abstract ResponseEntity<List<?>> readAllUsers();

	abstract ResponseEntity<?> updateUser(String userEmail, UserRequest userRequest);

	abstract ResponseEntity<?> deleteUser(String userEmail);

	abstract Integer calculateAge(UserRequest userRequest);

}
