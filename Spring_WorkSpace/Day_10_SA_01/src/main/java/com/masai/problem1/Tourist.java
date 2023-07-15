package com.masai.problem1;

import java.time.LocalDate;

public class Tourist {
	private String name;
	private int age;
	private String aadhar_id;
	public Tourist(String name, int age, String aadhar_id) {
		super();
		this.name = name;
		this.age = age;
		this.aadhar_id = aadhar_id;
	}
	@Override
	public String toString() {
		
		LocalDate ld= LocalDate.of(2023, 02, 28);
		return "Tourist [name=" + name + ", age=" + age + ", aadhar_id=" + aadhar_id + "]";
	} 
	
}
