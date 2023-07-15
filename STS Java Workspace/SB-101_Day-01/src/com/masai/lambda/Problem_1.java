package com.masai.lambda;

import java.util.*;

public class Problem_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
//		public Employee(int empId, String name, String address, int salary)
		Employee ep1 = new Employee(1,"Aman","Varanasi",4000);
		Employee ep2 = new Employee(2,"Anshu","Varanasi",3000);
		Employee ep3 = new Employee(3,"Shubham","Pune",5000);
		Employee ep4 = new Employee(4,"Manish","Dehradun",6000);
		Employee ep5 = new Employee(5,"Parimal","Kolkata",1000);
		Employee ep6 = new Employee(6,"Pankaj","Jaipur",4000);
		Employee ep7 = new Employee(7,"Mayur","Pune",500);
		Employee ep8 = new Employee(8,"Anuj","Gorakhpur",8000);
		Employee ep9 = new Employee(9,"Pradyum","Chandauli",3000);
		Employee ep10 = new Employee(10,"Mukesh","Lucknow",10000);
		
		list.add(ep1);
		list.add(ep2);
		list.add(ep3);
		list.add(ep4);
		list.add(ep5);
		list.add(ep6);
		list.add(ep7);
		list.add(ep8);
		list.add(ep9);
		list.add(ep10);
		
		list.forEach(emp->{
			if(emp.getSalary() < 5000) {
				emp.setSalary(emp.getSalary()+1000);
			}
		});
		
		System.out.println(list);
	}

}
