package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

//	Pid: int (primary key)
//	Name: varchar
//	SportName: varchar
//	Age: int
	@Id
	private int pId;
	private String name;
	private String sportName;
	private int age;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Player [pId=" + pId + ", name=" + name + ", sportName=" + sportName + ", age=" + age + "]";
	}
	
	
	
}
