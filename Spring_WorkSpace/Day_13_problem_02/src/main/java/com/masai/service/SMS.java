package com.masai.service;

import org.springframework.stereotype.Service;

@Service
public class SMS implements MessageService {

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("SMS : " + message);
	}

}
