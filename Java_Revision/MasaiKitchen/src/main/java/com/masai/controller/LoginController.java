package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.LoginDTO;
import com.masai.ecxeption.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.service.LoginService;

@RestController
@CrossOrigin("*")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginToApplication(LoginDTO dto) throws LoginException{
		CurrentUserSession cus = loginService.logIntoApplication(dto);
		
		return new ResponseEntity<>(cus,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/logout{uuid}")
	public String logoutFromApplication(@PathVariable("uuid") String uuid) throws LoginException{
		
		return loginService.logOutFromApplication(uuid);
	}
	
	
}
