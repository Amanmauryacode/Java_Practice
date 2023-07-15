package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.repository.EmailDao;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private EmailDao emailDao;

	@Override
	public List<User> getAllUser() throws UserException {
		List<User> users = userDao.findAll();
		if (users.isEmpty())
			throw new UserException("No User Fount In DataBase");
		return users;
	}

	@Override
	public User registerUser(User user) throws UserException {
		User u = userDao.save(user);
		if (u == null)
			throw new UserException("User not Register");
		return u;
	}

	@Override
	public User getUserById(Integer id) throws UserException {
		Optional<User> opt = userDao.findById(id);

		if (opt.isEmpty())
			throw new UserException("User Not Found!");
		return opt.get();
	}

	@Override
	public User deleteUserById(Integer id) throws UserException {
		Optional<User> opt = userDao.findById(id);

		if (opt.isEmpty())
			throw new UserException("User Not Found!");
		userDao.delete(opt.get());
		return opt.get();
	}

	@Override
	public Email getEmailDetailsFromUser(Integer uid, Integer eid) throws  EmailException {
		Email email = userDao.getEmailDetailsFromUser(uid, eid);
		if(email == null)throw new EmailException("Email Not Found For User : "+uid+" email id : "+eid);
		return email;
	}

	@Override
	public User createEmailForUser(Integer Id,Email email) throws EmailException, UserException {
		Optional<User> opt = userDao.findById(Id);

		if (opt.isEmpty())
			throw new UserException("User Not Found!");
		User u = opt.get();
		u.setEmail(email);
		email.setUser(u);
		
		return emailDao.save(email).getUser();
	}

}
