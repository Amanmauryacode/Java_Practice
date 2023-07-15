package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.exception.UserException;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User registerNewUser(User user) throws UserException {
		if(user == null) throw new UserException("User details not found");
		
		Optional<User> opt = userRepo.findByUserName(user.getUserName());
		if(opt.isPresent()) throw new UserException("User already registered with name : "+ user.getUserName());

		return userRepo.save(user);
	}

}
