package com.masai.Day06.problem2;


public class Main{

	public static void main(String[] args) throws Exception {
		
		Common c = new Common();
		Salman  s = new Salman(c);
		Hritik h  = new Hritik(c);
		s.start();
		h.start();
		
		s.join();
		h.join();
		
		System.out.println("Done...");
		
	}

}
