package com.masai.lambda.prob_2;

import java.util.*;



public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		
		list.add("Varanasi");
		list.add("Pune");
		list.add("Mumbai");
		list.add("Channai");
		list.add("Hydrabad");
		
		Collections.sort(list, (s1,s2)-> s2.compareTo(s1));
		System.out.println(list);
	}

}
