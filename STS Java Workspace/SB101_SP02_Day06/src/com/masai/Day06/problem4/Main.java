package com.masai.Day06.problem4;

public class Main {
	public static void main(String[] args) {
		
		Country c = new Country();
		
		Master m = new Master(c);
		Student s = new Student(c);
		
		m.start();
		s.start();
		try {
			m.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
