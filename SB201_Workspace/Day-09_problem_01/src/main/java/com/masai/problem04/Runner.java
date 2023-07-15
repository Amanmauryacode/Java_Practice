package com.masai.problem04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Runner {

	private Geometry shape;

	public void setShape(Geometry shape) {
		this.shape = shape;
	}

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Runner obj = ctx.getBean("rn",Runner.class);
		
		obj.shape.draw();
	}

}
