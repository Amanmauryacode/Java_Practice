package com.masai.service;

import com.masai.entity.User;
import com.masai.exception.UserException;

public interface UserService {

	public User registerNewUser(User user)throws UserException;
}
