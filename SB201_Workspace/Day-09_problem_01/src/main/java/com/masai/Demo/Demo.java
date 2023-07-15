package com.masai.Demo;

public class Demo {

	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setC(new Collage());
		t.teaches();
		
		Clerk c = new Clerk();
		c.setC(new Collage());
		c.registerStudent();
	}
}
