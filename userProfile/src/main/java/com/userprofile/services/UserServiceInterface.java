package com.userprofile.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.userprofile.exceptions.UserException;
import com.userprofile.model.UserRequest;

public interface UserServiceInterface {

	// add user
	// read user
	// read all users
	// update user
	// delete user
	// calculate age
	// validate mobile number

	abstract ResponseEntity<?> createUser(UserRequest userRequest) throws UserException;

	abstract ResponseEntity<?> readUser(String userEmail) throws UserException;

	abstract ResponseEntity<List<?>> readAllUsers() throws UserException;

	abstract ResponseEntity<?> updateUser(String userEmail, UserRequest userRequest) throws UserException;

	abstract ResponseEntity<?> deleteUser(String userEmail) throws UserException;

	abstract Integer calculateAge(UserRequest userRequest) throws UserException;

}
