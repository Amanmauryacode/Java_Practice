package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.User;
import com.masai.repository.userRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private userRepository userRepo;
	
	@Override
	public User registerUser(User user) {
		
		User u =userRepo.save(user);
		return u;
	}

}
