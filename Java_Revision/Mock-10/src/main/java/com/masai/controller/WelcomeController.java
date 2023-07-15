package com.masai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mock-10")
public class WelcomeController {
		
	
	@GetMapping("/welcome")
	public String welcome(){
		
	 return "welcome.html";
	}
		
	
	@GetMapping("/welcomePofile")
	public String welcomePofile(){
		
			return "userprofile.html";
	}

	@GetMapping("/admin")
	public String admin(){
		
		return "adminprofile.html";
	}
	
}
