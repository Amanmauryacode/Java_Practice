package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/users")
	public ResponseEntity<User> createBook(@RequestBody User user) {

		User u = userservice.registerUser(user);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}

}
