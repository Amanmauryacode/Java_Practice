package com.masai.service;

import com.masai.DTO.LoginDTO;
import com.masai.ecxeption.LoginException;
import com.masai.ecxeption.UserException;
import com.masai.model.CurrentUserSession;

public interface LoginService {
	public CurrentUserSession logIntoApplication(LoginDTO dto)throws LoginException;

	public String logOutFromApplication(String uuid)throws LoginException;

}
