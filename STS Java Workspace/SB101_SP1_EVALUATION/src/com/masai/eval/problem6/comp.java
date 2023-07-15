package com.masai.eval.problem6;

import java.util.Comparator;

public class comp implements Comparator<GroceryItems>{

	@Override
	public int compare(GroceryItems o1, GroceryItems o2) {
		// TODO Auto-generated method stub
		if(o1.getPrice() > o2.getPrice()) {
			return 1;
		}else if(o1.getPrice() < o2.getPrice()) {
			return -1;
		}
		else {
			if(o1.getUsedFrequency() >o2.getUsedFrequency()) {
				return 1;
			}else if(o1.getUsedFrequency() <o2.getUsedFrequency()) {
				return -1;
			}else {
				return o1.getName().compareTo(o2.getName());
			}
		}
	}

}
