package com.masai.day4.problem2;

import java.util.Objects;

class Strudent {
	
	private int roll;
	private String name;
	private String email;
	private int marks;
	
	
	public Strudent(int roll, String name, String email, int marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.marks = marks;
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
	@Override
	public int hashCode() {
		return Objects.hash(email, marks, name, roll);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Strudent other = (Strudent) obj;
		return Objects.equals(email, other.email) && marks == other.marks && Objects.equals(name, other.name)
				&& roll == other.roll;
	}



	@Override
	public String toString() {
		return "roll=" + roll + ", name=" + name + ", email=" + email + ", marks=" + marks + "\n";
	}
	
	
}
