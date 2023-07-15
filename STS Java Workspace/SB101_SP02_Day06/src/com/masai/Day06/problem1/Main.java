package com.masai.Day06.problem1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadB t2= new ThreadB();
		ThreadA t1= new ThreadA(t2);
		
		t1.start();
		t2.start();
	}

}
