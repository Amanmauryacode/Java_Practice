package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.LoginDTO;
import com.masai.ecxeption.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.SessionRepository;
import com.masai.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SessionRepository sessionRepo;

	@Override
	public CurrentUserSession logIntoApplication(LoginDTO dto) throws LoginException {
		User u = userRepo.findByUsername(dto.getUserName());
		
		if(u == null) {
			throw new LoginException("Invalid User Name");
		}
		
		Optional<CurrentUserSession> opt = sessionRepo.findById(u.getId());
		if(opt.isEmpty()) {
			if(u.getPassword().equals(dto.getPassword())) {
				
				CurrentUserSession cus = new CurrentUserSession();
				String uuid = RandomUuidGenerator.generateRandomString(8);
				cus.setUserId(u.getId());
				cus.setLocalDateTime(LocalDateTime.now());
				cus.setUuid(uuid);
				return sessionRepo.save(cus);
			}
			throw new LoginException("Wrong Password!");
		}
		throw new LoginException("User Already loged in !");
	}

	@Override
	public String logOutFromApplication(String uuid) throws LoginException {
		CurrentUserSession cus = sessionRepo.findByUuid(uuid);
		if(cus == null)throw new LoginException("User not logged in into application");
		sessionRepo.delete(cus);
		return "Successfully Logged out! ";
	}

}
