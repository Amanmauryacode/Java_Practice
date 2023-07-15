package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() throws UserException{
		List<User> users = userService.getAllUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException{
		
		User u = userService.registerUser(user);
		return new ResponseEntity<>(u,HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@Valid @PathVariable("id") Integer id) throws UserException{
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUserById(@Valid @PathVariable("id") Integer id) throws UserException{
		User user = userService.deleteUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}/mail/{mail_id}")
	public ResponseEntity<Email> getEmailFromUser(@Valid @PathVariable("id") Integer id,@PathVariable("mail_id") Integer eid) throws EmailException{
		Email email = userService.getEmailDetailsFromUser(id, eid);
		return new ResponseEntity<>(email,HttpStatus.OK);
	}
	
	@PostMapping("/users/{id}/mail")
	public ResponseEntity<User> createEmailForUser(@Valid @PathVariable("id")Integer id,@RequestBody Email email) throws UserException, EmailException{
		User user = userService.createEmailForUser(id, email);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
}
