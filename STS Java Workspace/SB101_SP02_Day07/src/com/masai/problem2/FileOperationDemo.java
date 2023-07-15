package com.masai.problem2;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileOperationDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String file = "A.txt";
		String contentToWrite = "Originally formed in 1600 purely to trade with the Mughal Empire, the Company needed to secure its commercial posts at Calcutta, Bombay and Madras. It purchased land from Indian rulers to build its settlements on, and recruited native armed forces to protect them. Eventually, these evolved into the Bengal, Bombay and Madras Armies.";
		String contentToAppend = "After successfully battling the French for trading supremacy, and simultaneously involving itself in local politics, the Company became India’s leading power following Robert Clive’s victory at Plassey in 1757. In the years that followed, it expanded its Indian domains.";
		
		ReadWriteCenter rwc = new ReadWriteCenter( file,  contentToWrite,  contentToAppend);
		
		Runnable write = () -> {
			try {
				rwc.writeToFile();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		};
		Runnable append = () -> {
			try {
				rwc.appendToFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(write);
		Thread t2 = new Thread(append);
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		
		Callable<List<Integer>> call = rwc::getAnalysis;
		
		ExecutorService service = Executors.newFixedThreadPool(1);
		
		Future<List<Integer>> ans = service.submit(call);
		service.shutdown();
		
		System.out.println("Total Digit count in file : " + ans.get().get(0));
		System.out.println("Total Letter count in file : " + ans.get().get(1));
		System.out.println("Total Special Character count in file : " + ans.get().get(2));
		
		System.out.println("Program Finished...");
		
		
		
		
	}

}
