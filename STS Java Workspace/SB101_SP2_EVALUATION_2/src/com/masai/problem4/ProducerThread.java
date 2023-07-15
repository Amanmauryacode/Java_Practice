package com.masai.problem4;

public class ProducerThread extends Thread{

	Common c ;

	public ProducerThread(Common c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.produce();
	}
	
}


class ConsumerThread extends Thread{
	Common c ;

	public ConsumerThread(Common c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.consumer();
	}
	
}