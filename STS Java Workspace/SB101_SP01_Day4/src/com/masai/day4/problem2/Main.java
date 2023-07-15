package com.masai.day4.problem2;
import java.util.*;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Strudent> list = new ArrayList<>();
		list.add(new Strudent(1,"Aman","amanmaurya@gmail.com",450));
		list.add(new Strudent(2,"Anshu","anshu@gmail.com",350));
		list.add(new Strudent(3,"Shubham","shubham@gmail.com",250));
		list.add(new Strudent(4,"Pankaj","pankaj@gmail.com",550));
		list.add(new Strudent(5,"Nagesh","nagesh@gmail.com",650));
		
		System.out.println(list.stream().max((s1,s2)->s1.getMarks()-s2.getMarks()));
		
	}

}
