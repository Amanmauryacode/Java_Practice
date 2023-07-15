package com.masai.eval.problem2;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> list1 = new ArrayList<>();
		Employee e = new Employee(1,"a0",250,"p");
		list1.add(new Student(1,"Aman",400,"Varanasi"));
		list1.add(new Student(2,"Shubham",600,"Pune"));
		list1.add(new Student(3,"Anuj",750,"Varanasi"));
		list1.add(new Student(4,"Shiv",500,"Chandauli"));
		list1.add(new Student(5,"Nagesh",350,"Lucknow"));
		
//		List<Employee> list3 = list1.stream()
//									.filter(std->std.getMarks()>500)
//									.map(s-> new Employee(s.getRoll(),s.getName(),s.getMarks()*10000,s.getAddress()))
//									.sorted((e1,e2)->(int) e2.getSalary()- (int)e1.getSalary())
//									.collect(Collectors.toList());
		
		List<Employee> list2 = list1.stream().map(s->{
			if(s.getMarks() >500) {
				return new Employee(s.getRoll(),s.getName(),s.getMarks()*10000,s.getAddress());
			}
			return null;
		}).filter(obj-> obj != null).sorted((e1,e2)->(int) e2.getSalary()- (int)e1.getSalary()).collect(Collectors.toList());
		
		
		list1.forEach(s->System.out.println(s));
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--");
		list2.forEach(emp->System.out.println(emp));
	}

}
