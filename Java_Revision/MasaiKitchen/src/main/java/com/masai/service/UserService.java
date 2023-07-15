package com.masai.service;

import com.masai.ecxeption.UserException;
import com.masai.model.User;

public interface UserService {

	public User registreNewUser(User user) throws UserException;
}
