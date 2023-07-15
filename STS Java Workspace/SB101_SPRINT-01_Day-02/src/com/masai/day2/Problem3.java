package com.masai.day2;
import java.util.*;

interface PrintList {
abstract void display(List<String> city);
}

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		
		list.add("Varanasi");
		list.add("Pune");
		list.add("Mumbai");
		list.add("Channai");
		list.add("Hydrabad");
		
		PrintList p = c-> System.out.println(c);
		
		p.display(list);
		
	}

}
