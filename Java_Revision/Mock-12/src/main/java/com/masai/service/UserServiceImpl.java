package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.UserDTO;
import com.masai.entity.User;
import com.masai.exception.UserException;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerNewUser(UserDTO dto) throws UserException {
		if (dto == null)
			throw new UserException("User Details must be Required");

		Optional<User> opt = userRepo.findByUserName(dto.getUserName());

		if (opt.isPresent())
			throw new UserException("User exist with user name : " + dto.getUserName());

		User user = new User();
		user.setUserName(dto.getUserName());
		user.setPassword(dto.getPassword());
		user.setAddress(dto.getAddress());
		user.setRole(dto.getRole());
		return userRepo.save(user);
	}

}
