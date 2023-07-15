package com.masai.Day06.problem2;


class Hritik extends Thread{
	
	Common c ;

	public Hritik(Common c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		c.oddPrint();
	}
}
