package com.masai;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Travel {

	private Vehicle vehicle;

	@Autowired
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@PostConstruct
	public void myInit() {
		System.out.println("Inside Intit Method");

	}

	@PreDestroy
	public void tearDown() {
		System.out.println("Inside Tear-Down Method");
	}

	public void travel() {
		vehicle.start();
	}
}
