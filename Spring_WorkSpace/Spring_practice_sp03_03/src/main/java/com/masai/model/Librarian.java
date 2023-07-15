package com.masai.model;

public class Librarian {
	private int id;
	private String name;
	private int age;
	private int noOfBooksIssued;
	private String email;
	private String mobile;

	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Librarian(int id, String name, int age, int noOfBooksIssued, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.noOfBooksIssued = noOfBooksIssued;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", age=" + age + ", noOfBooksIssued=" + noOfBooksIssued
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNoOfBooksIssued() {
		return noOfBooksIssued;
	}

	public void setNoOfBooksIssued(int noOfBooksIssued) {
		this.noOfBooksIssued = noOfBooksIssued;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
