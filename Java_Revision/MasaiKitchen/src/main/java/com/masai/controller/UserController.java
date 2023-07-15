package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.ecxeption.UserException;
import com.masai.model.User;
import com.masai.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException {

		User u = userService.registreNewUser(user);

		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}

}
