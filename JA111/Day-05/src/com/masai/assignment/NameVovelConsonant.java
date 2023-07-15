package com.masai.assignment;
import java.util.*;

public class NameVovelConsonant {

	
	  static int getVowelCount(String name) {
	    String[] arr = name.split("");
	    int vovel = 0;
	    for(int i=0;i<arr.length;i++) {
	    	if(arr[i].toLowerCase().equals("a") ||arr[i].toLowerCase().equals("e") ||arr[i].toLowerCase().equals("i") ||arr[i].toLowerCase().equals("o") ||arr[i].toLowerCase().equals("u")  ) {
	    		vovel++;
	    	}
	    }
	    
	    return vovel;
	  }
	  public static void main(String[] args) {
//	    
		  
		  Scanner sc = new Scanner(System.in);
		  
		  String name = sc.next();
		  System.out.println("Total vowel in "+name+" is " + getVowelCount(name));
		    System.out.println("Total vowel in "+name+" is " + (name.length()- getVowelCount(name)));
		  
	  }
	  
	

}
