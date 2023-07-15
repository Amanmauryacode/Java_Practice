package com.masai.problem2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public void writeStudent() {
		
		try {
			FileWriter fw = new FileWriter("student.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Anuj 56.25 77.58");
			bw.newLine();
			
			bw.write("Bharat 66.25 57.58");
			bw.newLine();
			
			bw.write("Chaman 70.25 66.74");
			bw.newLine();
			
			bw.write("Dhanush 58.25 95.74");
			bw.newLine();
			
			bw.write("Garv 58.62 95.74");
			bw.newLine();
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public String studentMaxaAttendence() throws Exception {
		
		String[] arr = {"",""};
		
		FileReader fr = new FileReader("student.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		while(line != null) {
			
			String att = line.split(" ")[2];
			if(att.compareTo(arr[1]) >=1) {
				arr[0] = line.split(" ")[0];
				arr[1] = att;
			}
			line = br.readLine();
		}
		br.close();
		return arr[0];
	}
	
	public Double averagePercentage() throws Exception {
		Double avg = 0.0;
		int count =0;
		FileReader fr = new FileReader("student.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		while(line != null) {
			avg += Double.parseDouble(line.split(" ")[2]);
			count++;
			line = br.readLine();
		}
		br.close();
		return avg/count;
	}
	
	
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		
		Runnable write = ()->m.writeStudent();
		Callable<String> c1 = ()->m.studentMaxaAttendence();
		Callable<Double> c2 = ()->m.averagePercentage();
		
		Thread t1 = new Thread(write);
		t1.start();
		t1.join();
		
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<String> name =  es.submit(c1);
		
		Future<Double> percentage = es.submit(c2);
		es.shutdown();
		System.out.println("Student whose Attendance is highest : "+name.get());
		System.out.println("Average Percentage of Attendance : "+percentage.get());
		
	}
}
