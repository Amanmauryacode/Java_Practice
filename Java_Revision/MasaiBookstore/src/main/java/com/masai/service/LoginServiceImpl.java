package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.LoginDTO;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.SessionDao;
import com.masai.repository.userRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private userRepository userRepo;
	@Autowired
	private SessionDao sDao;

	@Override
	public CurrentUserSession logIntoAccount(LoginDTO dto) throws LoginException {

		User user = userRepo.findByUsername(dto.getUsername());
		
		if(user == null) {
			throw new LoginException("Invalid User name");
		}
		
		Optional<CurrentUserSession> opt = sDao.findById(user.getId());
		
		if(opt.isPresent()) {
			throw new LoginException("User already login into System");
		}
		
		if(dto.getPassword().equals(user.getPassword())) {
			
			String uuid = RandomUuidGenerator.generateRandomString(9);
			
			CurrentUserSession cus = new CurrentUserSession(user.getId(), uuid, LocalDateTime.now());
			
			return sDao.save(cus);
		}
		return null;
	}

	@Override
	public String logOutFromAccount(String uuid) throws LoginException {
		CurrentUserSession cus = sDao.findByUuid(uuid);

		if (cus == null) {
			throw new LoginException("User not login into our System");
		}
		sDao.delete(cus);
		return "Logout Successfully !";
	}

}
