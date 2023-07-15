package com.masai.lambda.prob_4;
import java.security.KeyStore.Entry;
import java.util.*;

class Student{
	private int roll;
	private String name;
	private String email;
	private int marks;
	private String country;
	
	public Student(int roll, String name, String email, int marks, String country) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.marks = marks;
		this.country = country;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "roll=" + roll + ", name=" + name + ", email=" + email + ", marks=" + marks + ", country="
				+ country + "\n";
	}
	
	
	
	
}


public class Demo_3 {
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		Map<String, Student> map = new HashMap<>();
		
		list.add(new Student(1,"Aman","amanmaurya@gmail.com",450,"India"));
		list.add(new Student(2,"Anshu","anshu@gmail.com",350,"Pakistan"));
		list.add(new Student(3,"Shubham","shubham@gmail.com",250,"Amrica"));
		list.add(new Student(4,"Pankaj","pankaj@gmail.com",550,"Africa"));
		list.add(new Student(5,"Nagesh","nagesh@gmail.com",650,"Austrila"));
		
		for(int i=0;i<list.size();i++) {
			if(map.containsKey(list.get(i).getCountry())) {
				map.put(list.get(i).getCountry(), map.get(list.get(i)));
			}else {
				map.put(list.get(i).getCountry(), list.get(i));
			}
		}
		Demo_3 d = new Demo_3();
		
		Map<String, Student> map2 = d.sortMapUsingStudentName(map);
		
		
		
		
	}
	public Map<String, Student> sortMapUsingStudentName(Map<String, Student> originalMap){
		Map<String, Student> map = new LinkedHashMap<>();
		
		Set<Map.Entry<String, Student>> set = originalMap.entrySet();
		
		List<Student> list = new ArrayList<>();
		
		for(Map.Entry<String, Student> el : set) {
			list.add(el.getValue());
		}
		
		
		Collections.sort(list, (s1,s2)->s2.getName().compareTo(s1.getName()));
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			if(map.containsKey(list.get(i).getCountry())) {
				map.put(list.get(i).getCountry(), map.get(list.get(i)));
			}else {
				map.put(list.get(i).getCountry(), list.get(i));
			}
		}
		
		return map;
	}
}
