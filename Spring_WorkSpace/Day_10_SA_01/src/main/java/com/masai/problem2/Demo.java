package com.masai.problem2;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	private Map<Department, Employee> theMap;
	//use setter injection to inject theMap;

	public void myInit(){
		System.out.println("inside myInit method");
	}

	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}

	public void cleanUp(){
		System.out.println("inside cleanUp method");
	}

	public void showDetails(){
		System.out.println("inside showDetails of Demo class");
		//print all the details of all the employees department-wise.
		
		for(Map.Entry<Department, Employee> set : theMap.entrySet()) {
			System.out.println(set.getKey() +"<--->"+set.getValue());
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext clx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo d = clx.getBean("Demo",Demo.class);
		
		d.showDetails();
		ClassPathXmlApplicationContext clx2 = (ClassPathXmlApplicationContext) clx;
		clx2.close();
	}
}
