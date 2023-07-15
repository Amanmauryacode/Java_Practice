package com.masai.usecases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.service.EventOrganizerImpl;
import com.masai.util.AppConfig;

public class Main {

	public static void main(String[] args) {
		ApplicationContext clx = new AnnotationConfigApplicationContext(AppConfig.class);
		EventOrganizerImpl eo = clx.getBean("eventOrganizerImpl",EventOrganizerImpl.class);
		eo.findArtist("Singer");
		
		((AnnotationConfigApplicationContext)clx).close();
	}
}
