package com.masai.Day06.problem2;

public class Common {
	boolean flag = true;
	synchronized public void evenPrint() {
		
		 for(int i=0;i<=20;i+=2) {
			 if(flag== false) {
				 try {
						wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 }
			flag = false;
			 System.out.println(i+" ");
			 notify();
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}
	
	synchronized public void oddPrint() {
		
		
		for(int i=1;i<20;i+=2) {
			if(flag) {
				 try {
						wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 }
			flag = true;
			 System.out.println(i+" ");
			 notify();
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		notify();
			
	}
}
