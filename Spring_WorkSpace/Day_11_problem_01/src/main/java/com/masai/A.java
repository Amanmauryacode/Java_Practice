package com.masai;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Autowired
	private List<String> cities; // read the 5 cities name from the properties file and
	// inject it into his List.
	@Autowired
	private List<Student> students;
	
	@PostConstruct
	public void myInit() {
		System.out.println("Inside Init Method");
	}
	
	@PreDestroy
	public void tearDown() {
		System.out.println("Inside Tear-Down Mathod");
	}
	
	public void show() {
		System.out.println(cities);
		System.out.println(students);
	}
}
