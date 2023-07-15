package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.masai.service.MessageService;
@Controller
public class MessageProcessorImpl implements MessageProcessor {
	@Autowired
	@Qualifier("tw")
	MessageService messageService;
	
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}


	@Override
	public void processMessage(String message) {
		messageService.sendMessage(message);
		
	}

}
