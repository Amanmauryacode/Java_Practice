package com.masai.eval.problem5b;


interface Intr{
	boolean containsChar(String s1, String s2);
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Intr i1 = new Intr() {
			@Override
			public boolean containsChar(String s1, String s2) {
				for(int i=0;i<s2.length();i++) {
					if(s1.indexOf(s2.charAt(i))!=-1) {
						return true;
					}
				}
				return false;
			}		
		};
		System.out.println(i1.containsChar("MASAI",  "PUT"));
		System.out.println(i1.containsChar("JAHAN",  "NOE"));
	}

}
