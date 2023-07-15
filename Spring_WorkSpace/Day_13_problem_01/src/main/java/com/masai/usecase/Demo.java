package com.masai.usecase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masai.service.PersonService;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext clx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonService ps = clx.getBean("ps",PersonService.class);
		
		ps.printPersonList();
		ps.printSkillMap();
	}
}
