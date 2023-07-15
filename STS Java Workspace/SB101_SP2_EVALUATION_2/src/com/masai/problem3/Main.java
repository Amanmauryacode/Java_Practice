package com.masai.problem3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Map<String,Double> prodMap = new HashMap<>();
		
		prodMap.put("salt",30.00);
		prodMap.put("turmeric",35.00);
		prodMap.put("cumin",40.00);
		prodMap.put("cinnamon",70.00);
		prodMap.put("mace",25.00);
		
		serializationProduct.sserialiezed(prodMap);
		
		Map<String,Double> productList =  deserialiezedProduct.deserialiezed();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Species Name : ");
		String name = sc.next();
		System.out.print("Enter the Number of Packets : ");
		int qty = sc.nextInt();
		System.out.println("Total Bill Amount : "+ productList.get(name)*qty);

	}

}
