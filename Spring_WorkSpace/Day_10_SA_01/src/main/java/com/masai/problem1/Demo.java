package com.masai.problem1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext clx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HolidayPackage hp = clx.getBean("HP",HolidayPackage.class);
		
		hp.showDetails();
	}
}
