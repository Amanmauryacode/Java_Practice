package com.masai.service;

import java.util.List;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;

public interface UserService {

	public List<User> getAllUser()throws UserException;
	
	public User  registerUser(User user)throws UserException;
	
	public User getUserById(Integer id)throws UserException;
	
	public User deleteUserById(Integer id)throws UserException;
	
	public Email getEmailDetailsFromUser(Integer uid,Integer eid)throws EmailException;

	public User createEmailForUser(Integer Id, Email email) throws EmailException, UserException;
	
	
}
