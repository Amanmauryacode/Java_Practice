package com.masai.Day05.problem1;

public class ThreadB implements Runnable {

	
	
	@Override
	public void run() {
		int mult = 1;
		for(int i=1;i<11;i++) {
			mult*=i;
		}
		
		System.out.println(Thread.currentThread().getName()+" "+ mult);
		
	}

}
