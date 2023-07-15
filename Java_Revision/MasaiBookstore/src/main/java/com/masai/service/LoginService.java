package com.masai.service;

import com.masai.DTO.LoginDTO;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;

public interface LoginService {
	public CurrentUserSession logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String uuid)throws LoginException;

}
