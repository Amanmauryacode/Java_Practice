package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.User;
import com.masai.exception.UserException;
import com.masai.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerNewUser(@Valid @RequestBody User user) throws UserException {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User u = userService.registerNewUser(user);
		return new ResponseEntity<>(u,HttpStatus.CREATED);
		
	}
}
