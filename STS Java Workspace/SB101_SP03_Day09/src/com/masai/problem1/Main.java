package com.masai.problem1;

public class Main {
	static int count =10;
	public static void fib() {
		for(int i=0;i<10;i++) {
			System.out.println((i+1)+" Term of Fibonacci Series Thread: "+fibo(i)); 
		}
	}
	
	public static int fibo(int n) {
		if(n == 0 || n ==1)return n;
		return fibo(n-1)+fibo(n-2);
	}
	
	public static void rev() {
		for(int i=10;i>=0;i--) {
			System.out.println("Reverse Number Thread : "+i);
		}
	}
	public static void main(String[] args) {
		
		Runnable Fibonacci = Main::fib;
		Runnable revNum = Main::rev;
		
		Thread t1 = new Thread(Fibonacci);
		Thread t2 = new Thread(revNum);
		
		t1.start();
		t2.start();
	}

}
