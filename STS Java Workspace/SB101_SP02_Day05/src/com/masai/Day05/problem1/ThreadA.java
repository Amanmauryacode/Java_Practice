package com.masai.Day05.problem1;

public class ThreadA extends Thread{
	


	@Override
	public void run() {
		
		int sum =0;
		
		for(int i=0;i<11;i++) {
			sum+=i;
		}
		System.out.println(Thread.currentThread().getName()+" "+sum);
		
	}

}
