package com.masai.day15;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashingDemo {
	
	public static Map<Character, List<String>> addName(String names[]){
		
		Map<Character, List<String>> map = new TreeMap<>();
		
		for(int i=0; i<names.length; i++){
			
			char firstLetter = names[i].charAt(0);
			
			if(!map.containsKey(firstLetter)) {
				List<String> newnames = new ArrayList<>();
				newnames.add(names[i]);
				map.put(firstLetter, newnames);
			}else {
				map.get(firstLetter).add(names[i]);
			}
			
		}
		return map;
	}
	
	public static void display(Map<Character, List<String>> map) {
		
	   Set<Map.Entry<Character, List<String>>> entries = map.entrySet();
	   
	   for(Map.Entry<Character, List<String>> entry:entries) {
		   
		   char c = entry.getKey();
		   List<String> values = entry.getValue();		   
		   System.out.println(c+": "+String.join(",", values));
	   }
	}
	
	public static boolean searchName(Map<Character, List<String>> map, String name) {
		boolean isPresent = false;
		Character c = name.charAt(0);
		if(map.containsKey(c)) {
			List<String> name1 = map.get(c);
			
			isPresent = name1.contains(name);
		}
		
		return isPresent;
	}
	
	public static boolean removeName(Map<Character, List<String>> map, String name) {
		boolean isA = false;
		
		Character c = name.charAt(0);
		if(map.containsKey(c)) {
			List<String> name1 = map.get(c);
			
			isA = name1.remove(name);
		}
		
		return isA;
	}
	
	
	 public static void main(String[] args) {
		    String names[] = {"Naya", "Ishaan", "Jai", "Inaya", "Amar", "Navi", "Dhruv",
		        "Kanan", "Diya", "Shyla", "Agastya", "Ananya", "Nila", "Tenzin", "Tamia",
		        "Shaan", "Ajay", "Jaya", "Anjali", "Aditi", "Reva", "Sahil", "Darsh", "Aja",
		        "Ambar", "Deven", "Ishani", "Kavi", "Marjane", "Jasleen", "Ashwin", "Aadhira",
		        "Candy", "Kum", "Salina", "Artha", "Raghav", "Avan", "Sitara", "Shylah", "Divya",
		        "Varun", "Sona", "Shaila", "Kimaya", "Farid", "Kashvi", "Devi", "Charu", "Mihir", "Tulsi",
		        "Anila", "Anala", "Vivan", "Amitabh", "Mahika", "Sudhir", "Lata", "Anand", "Akshay"};
		    
		    Map<Character, List<String>> map = addName(names);
		    
		    System.out.println("The original map is ");
		    display(map);
		    
		    System.out.println();
		    if(searchName(map, "Farid")) {
		      System.out.println("Name 'Farid' found in Map");
		    }else {
		      System.out.println("Name 'Farid' not found in Map");
		    }
		    
		    System.out.println();
		    if(searchName(map, "Harish")) {
		      System.out.println("Name 'Harish' found in Map");
		    }else {
		      System.out.println("Name 'Harish' not found in Map");
		    }
		    
		    System.out.println();
		    if(removeName(map, "Lata")) {
		      System.out.println("Name 'lata' removed from Map");
		    }else {
		      System.out.println("Name 'lata' not in map hence not deleted");
		    }

		    System.out.println();
		    if(removeName(map, "Harish")) {
		      System.out.println("Name 'Harish' removed from Map");
		    }else {
		      System.out.println("Name 'Harish' not in map hence not deleted");
		    }
		    
		    System.out.println();
		    display(map);
		  }
}

