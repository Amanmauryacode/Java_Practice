package com.masai.service;

import org.springframework.stereotype.Service;

@Service(value = "tw")
public class Twitter implements MessageService {

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("Twitter : " + message);

	}

}
