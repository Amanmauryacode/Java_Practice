package com.masai;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "vehicle")
public class Bike implements Vehicle {

	public void ride() {
		System.out.println("Bike Strat...");
	}

	@Override
	public void start() {
		ride();
		
	}
}
