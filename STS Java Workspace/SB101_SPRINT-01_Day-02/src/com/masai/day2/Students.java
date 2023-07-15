package com.masai.day2;

class Students{
	private int roll;
	private String name;
	private String email;
	private int marks;
	private String country;
	
	public Students(int roll, String name, String email, int marks, String country) {
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