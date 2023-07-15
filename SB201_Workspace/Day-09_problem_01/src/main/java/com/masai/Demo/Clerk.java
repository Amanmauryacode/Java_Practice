package com.masai.Demo;

public class Clerk {
	private University c ;
	
	public void setC(University c) {
		this.c = c;
	}
	public void registerStudent() {
		c.run();
		System.out.println("enroll the Student in Collage");
	}
}
