package com.userprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userprofile.model.UserRequest;
import com.userprofile.services.interfaces.UserServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserServiceInterface userServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody @Valid UserRequest userRequest) {
		return userServiceImpl.createUser(userRequest);
	}

	@GetMapping("/view/{userEmail}")
	public ResponseEntity<?> readUser(@PathVariable String userEmail) {
		return userServiceImpl.readUser(userEmail);
	}

	@GetMapping("/view-all")
	public ResponseEntity<List<?>> readAllUsers() {
		return userServiceImpl.readAllUsers();
	}

	@PutMapping("/update/{userEmail}")
	public ResponseEntity<?> updateUser(@PathVariable String userEmail, @RequestBody @Valid UserRequest userRequest) {
		return userServiceImpl.updateUser(userEmail, userRequest);
	}

	@DeleteMapping("/remove/{userEmail}")
	public ResponseEntity<?> deleteUser(@PathVariable String userEmail) {
		return userServiceImpl.deleteUser(userEmail);
	}
}
