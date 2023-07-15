package com.masai.eval.problem6;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Mian implements Comparator<GroceryItems> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Set<GroceryItems> set1 = new TreeSet<>(new Mian());
		Set<GroceryItems> set2 = new TreeSet<>(new comp());
		set1.add(new GroceryItems(20,"soap",5));
		set1.add(new GroceryItems(50,"Biscut",8));
		set1.add(new GroceryItems(10,"Popcon",15));
		set1.add(new GroceryItems(20,"Colgate",5));
		set1.add(new GroceryItems(20,"top",4));
		
		set2.add(new GroceryItems(20,"soap",5));
		set2.add(new GroceryItems(50,"Biscut",8));
		set2.add(new GroceryItems(10,"Popcon",15));
		set2.add(new GroceryItems(20,"Colgate",5));
		set2.add(new GroceryItems(20,"top",4));
		
		System.out.println(set1);
		System.out.println();
		System.out.println(set2);
	}

	@Override
	public int compare(GroceryItems o1, GroceryItems o2) {
		if(o1.getUsedFrequency() < o2.getUsedFrequency()) {
			return 1;
		}else if(o1.getUsedFrequency() > o2.getUsedFrequency()) {
			return -1;
		}else {
			if(o1.getPrice() < o2.getPrice()) {
				return 1;
			}else if(o1.getPrice() > o2.getPrice()) {
				return -1;
			}else {
				return o2.getName() .compareTo(o1.getName());
			}
		}
	}


	
	
	
	

}
