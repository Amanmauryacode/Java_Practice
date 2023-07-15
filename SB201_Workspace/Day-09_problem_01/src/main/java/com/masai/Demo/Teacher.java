package com.masai.Demo;

public class Teacher {
	private University c;

	public void setC(University c) {
		this.c = c;
	}

	public void teaches() {
		c.run();
		System.out.println("Teacher teaches");
	}
}
