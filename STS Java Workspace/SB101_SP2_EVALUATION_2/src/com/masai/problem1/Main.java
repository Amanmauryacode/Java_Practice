package com.masai.problem1;

public class Main {

	public static void main(String[] args) throws Exception {
			
		Dhoni d = new Dhoni() ;
		Virat v = new Virat();
		Rohit r = new Rohit();
		
		d.setPriority(10);
		
		d.start();
		d.join();
		
		r.start();
		r.join();
		
		v.start();
		v.join();
		
		
	}

}
