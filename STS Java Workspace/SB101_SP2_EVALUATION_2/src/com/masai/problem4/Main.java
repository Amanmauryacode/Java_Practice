package com.masai.problem4;

public class Main {

	public static void main(String[] args) throws Exception {
		Common c = new Common();
		
		ProducerThread produce = new ProducerThread(c);
		ConsumerThread consumer = new ConsumerThread(c);
		
		produce.start();
		consumer.start();
		
		produce.join();
		consumer.join();
		
		System.out.println("Main Done...");
		
	}
}
