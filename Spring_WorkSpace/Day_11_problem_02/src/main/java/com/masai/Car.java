package com.masai;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

	public void drive() {
		System.out.println("Car Start...");
	}

	@Override
	public void start() {
		drive();
	}

	
}
