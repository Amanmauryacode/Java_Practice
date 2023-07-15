package com.masai.Day06.problem1;

public class ThreadA extends Thread{
	Thread tr;

	public ThreadA(Thread tr) {
		super();
		this.tr = tr;
	}
	@Override
	public void run() {
		
		try {
			tr.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<=10;i++) {
			if(i%2==1)System.out.print(i+" ");
		}
	}
	
}
