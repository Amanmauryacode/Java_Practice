package com.masai.day4.problem4;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> set1 = new TreeSet<>((s1,s2)-> s1.getMarks()-s2.getMarks()); 
		set1.add(new Student(1,"Aman","amanmaurya@gmail.com",450));
		set1.add(new Student(2,"Anshu","anshu@gmail.com",350));
		set1.add(new Student(3,"Shubham","shubham@gmail.com",250));
		set1.add(new Student(3,"Shubham","shubham@gmail.com",250));
		set1.add(new Student(4,"Pankaj","pankaj@gmail.com",550));
		set1.add(new Student(5,"Nagesh","nagesh@gmail.com",650));
		
		Set<Student> set2 = set1.stream().distinct().filter(s->s.getMarks()<500).collect(Collectors.toSet());
		System.out.println(set2);
	}

}
