package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masai.entity.User;
import com.masai.repository.UserRepository;

@Controller
@RequestMapping("/mock-10/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User us = userRepo.save(user);
		
		return new ResponseEntity<>(us,HttpStatus.CREATED);
		
	}
}
