package com.masai.problem1;

public class Rohit extends Thread{

	@Override
	public void run() {
		int mult =1;
		
		for(int i=1;i<=10;i++) {
			mult*=i;
		}
		System.out.println(mult);
	}
}
