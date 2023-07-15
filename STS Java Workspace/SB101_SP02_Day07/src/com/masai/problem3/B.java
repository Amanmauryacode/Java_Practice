package com.masai.problem3;

//class A{
//	____________ ____________ void fun(){ ----- (1), (2)
//		....
//	}
//}

public class B implements Runnable{
//	A a = new A();
	
	 public void run(){
//		synchronized(A.class){ //---- (3)
//			...
//		}
		
		//say wait method is called somwhere for this thread
//		notify();	---- (4)
	}
}
// 1. synchronized.
// 2. static.
// 3 A.class.
// 4 wait and notify always used inside synchronized block
 