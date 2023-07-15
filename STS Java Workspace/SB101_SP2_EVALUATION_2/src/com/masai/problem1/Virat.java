package com.masai.problem1;

public class Virat extends Thread{

	@Override
	public void run() {
		int sum = 0;
		for(int i=1;i<=20;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
}
