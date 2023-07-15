package com.masai.Day06.problem2;

public class Salman extends Thread {
	Common c ;

	public Salman(Common c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		c.evenPrint();
	}
	
	
}

