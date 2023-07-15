package com.masai.eval.problem6;

import java.util.Comparator;

public class NaturalComp implements Comparator<GroceryItems> {

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
