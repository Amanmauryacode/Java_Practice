package com.masai.Day06.problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		child c1 = new child(list);
		c1.start();
		try {
			c1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list = c1.getList();
		
		list.forEach(System.out::println);
		
		
	}

}

class child extends Thread{
	
	List<String> list;
	
	
	
	public child(List<String> list) {
		super();
		this.list = list;
	}



	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		int count =0;
		while(count !=4) {
			System.out.println("Enter Any City Name : ");
			list.add(sc.next());
			count++;
		}	
		sc.close();
	}
	
	public List<String> getList(){
		return list;
	}
}

