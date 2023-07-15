package com.masai.problem2;

public class Department {
	private int deptId;
	private String deptName;
	private String location;
	//use constructor injection to inject the above fields.
	//override the toString method with all the above fields
	public Department(int deptId, String deptName, String location) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location + "]";
	}
	
}
