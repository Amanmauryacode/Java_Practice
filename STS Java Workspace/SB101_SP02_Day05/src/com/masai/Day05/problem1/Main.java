package com.masai.Day05.problem1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA ta = new ThreadA();
		ThreadB tb = new ThreadB();
		
		Thread t1 = new Thread(ta);
		Thread t2 = new Thread(tb);
		
		t1.setName("Salman");
		t2.setName("Hritik");
		Thread.currentThread().setName("Akshay");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<=10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}

}
