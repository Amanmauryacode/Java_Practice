package com.masai.Day06.problem1;

public class ThreadB extends Thread{

	@Override
	public void run() {
		
		for(int i=0;i<=10;i++) {
			if(i%2==0)System.out.print(i+" ");
		}
	}
}
