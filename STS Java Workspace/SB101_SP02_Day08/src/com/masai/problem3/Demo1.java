package com.masai.problem3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("studentdata.txt");		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		List<Student> studentList = new ArrayList<>();
		
		
		Address a1 = new Address("Uttar Pradesh","Varanasi",232101);
		Student s1 = new Student(1,"Aman",550,"1245785A",a1);
		
		Address a2 = new Address("Uttar Pradesh","Varanasi",232101);
		Student s2 = new Student(1,"Rounak",550,"1245785A",a1);
		
		Address a3 = new Address("Uttar Pradesh","Varanasi",232101);
		Student s3 = new Student(1,"Naman",550,"1245785A",a1);
		
		Address a4 = new Address("Uttar Pradesh","Varanasi",232101);
		Student s4 = new Student(1,"Shubham",550,"1245785A",a1);
		
		Address a5 = new Address("Uttar Pradesh","Varanasi",232101);
		Student s5 = new Student(1,"Pankaj",550,"1245785A",a1);
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		
		oos.writeObject(studentList);
		oos.close();
		System.out.println("Done...");
		
	}

}
class Address implements Serializable{
	 String state;
	 String city; 
	 int pincode;
	public Address(String state, String city, int pincode) {
		super();
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	 
}
class Student implements Serializable{
	 int roll;
	 String name;
	 int marks;
	 String Password;
	 Address address;
	public Student(int roll, String name, int marks, String password, Address address) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		Password = password;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + ", Password=" + Password + ", address="
				+ address + "]";
	}
	
	 
}