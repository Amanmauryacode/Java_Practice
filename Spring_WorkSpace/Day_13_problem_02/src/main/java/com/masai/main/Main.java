package com.masai.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.config.AppConfig;
import com.masai.controller.MessageProcessorImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext clx = new AnnotationConfigApplicationContext(AppConfig.class);
		 
		MessageProcessorImpl msi = clx.getBean(MessageProcessorImpl.class);
		msi.processMessage("Hello");
	}
}
