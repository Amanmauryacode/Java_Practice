package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.ecxeption.UserException;
import com.masai.model.User;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registreNewUser(User user) throws UserException {
		
		User u = userRepo.findByUsername(user.getUsername());
		if(u == null) {
			user.setRegistrationDate(LocalDate.now());
			return userRepo.save(user);
		}
		throw new UserException("User Exist with same username!");
	}

}
