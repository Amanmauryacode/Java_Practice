package com.masai.service;

import com.masai.dto.UserDTO;
import com.masai.entity.User;
import com.masai.exception.UserException;

public interface UserService {

	public User registerNewUser(UserDTO dto)throws UserException;
	
	
}
