package com.masai.Day06.problem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Country {
	public static  Map<String,String> map ;
	static String countryName = null;
	static {
		map = new HashMap<>();
		map.put("Afghanistan", "kabul");
		map.put("Belgium", "Brussels");
		map.put("Canada", "Ottawa");
		map.put("Egypt", "Cairo");
		map.put("Finland", "Helsinki");
		map.put("Greece", "Athens");
		map.put("Hungary", "Budapest");
		map.put("Iraq", "Baghdad");
		map.put("Norway", "Oslo");
		map.put("South Korea", "Seoul");
	}
	
	synchronized void askCapitalName() {
		List<String> country = new ArrayList<>(map.keySet());

		while(!country.isEmpty()) {
			int max = country.size()-1;
			int range = max-0+1;
			int ind =  (int)(Math.random() * range) + 0;
			countryName = country.get(ind);
			country.remove(ind);
			System.out.println("Guess The Capital of : "+ countryName);
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	synchronized void printCapitalName() {
		if(countryName == null){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!map.isEmpty()) {
			System.out.println("Captial of Country " + countryName+" is : "+ map.get(countryName));
			map.remove(countryName);
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

class Master extends Thread{
	Country c ;
	
	public Master(Country c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.askCapitalName();
	}
}

class Student extends Thread{
	Country c;

	public Student(Country c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		c.printCapitalName();
	}
}
