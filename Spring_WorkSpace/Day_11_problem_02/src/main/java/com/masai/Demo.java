package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext clx = new AnnotationConfigApplicationContext(AppConfig.class);
		Travel t = clx.getBean("travel",Travel.class);
		
		t.travel();
		
		((AnnotationConfigApplicationContext)clx).close();
	}
}
