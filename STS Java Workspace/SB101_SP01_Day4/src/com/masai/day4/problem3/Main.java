package com.masai.day4.problem3;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		list1.add(4);
		list1.add(8);
		list1.add(15);
		list1.add(18);
		list1.add(45);
		
		for(int i=0;i<list1.size();i++) {
			list2.add((int)Math.pow(list1.get(i), 2));
		}
		
		list1.forEach(i->System.out.println(i));
		System.out.println();
		list2.forEach(i->System.out.println(i));
	}

}
