package com.masai.usecases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masai.service.ArtistService;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext clx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ArtistService as = clx.getBean("ArtistService",ArtistService.class);
		as.printArtistList();
		System.out.println("---------------------------------");
		as.printArtworkMap();
	}
}
