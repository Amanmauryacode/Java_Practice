package com.masai.day4.problem1;
import java.util.*;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1,"Soap",300,5));
		list.add(new Product(2,"Biscuit",600,10));
		list.add(new Product(3,"Oil",500,12));
		list.add(new Product(4,"Hot Dog",450,8));
		list.add(new Product(1,"Sprite",250,15));
		
		List<Product> newList = list.stream().filter(p1->p1.getQuantity()>10).sorted((p1,p2)-> p1.getPrice()-p2.getPrice()).collect(Collectors.toList());
		
		System.out.println(list);
		System.out.println("-=-=-==-=-=-=-=-=-=--=-=-=-");
		System.out.println(newList);
		
	}

}
