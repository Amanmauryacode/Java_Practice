package com.masai.Demo;

public class Collage implements University {
	public void doJob() {
		System.out.println("Job is started");
		// here it needs the service of its Dependencies
	}

	public void run() {
		Collage c = new Collage();
		c.doJob();
	}
}
