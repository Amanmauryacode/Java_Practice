package com.masai.problem4;

public class Common {
	
	static int num = 0;
	boolean flag = true;
	
	public  void produce() {
		int count =6;
		while(count!=0) {
			synchronized (this) {
				if(flag==false) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				flag = false;
				num = (int) (Math.random()*6+0);
				
				System.out.println("Producer Produced: " + num);
				count--;
				notify();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void consumer() {
		int count =6;
		
		while(count!=0) {
			synchronized (this) {
				if(flag) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				flag = true;
				
				int sum = 0;
				for(int i=0;i<=num;i++) {
					sum+=i;
				}
				System.out.println("Consumer Calculated Sum is: "+sum);
				System.out.println();
				count--;
				notify();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
}
