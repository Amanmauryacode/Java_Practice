package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.UserDTO;
import com.masai.entity.User;
import com.masai.exception.UserException;
import com.masai.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO dto) throws UserException{
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		User user= userService.registerNewUser(dto);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
}
