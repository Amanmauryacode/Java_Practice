package com.masai.eval.problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.masai.eval.problem2.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list1 = new ArrayList<>();
		list1.add(new Student(1,"Aman",400,"Varanasi"));
		list1.add(new Student(2,"Shubham",600,"Pune"));
		list1.add(new Student(3,"Anuj",750,"Varanasi"));
		list1.add(new Student(4,"Shiv",500,"Chandauli"));
		list1.add(new Student(5,"Nagesh",350,"Lucknow"));
		list1.add(new Student(6,"Rajesh",750,"Gorakhpur"));
		list1.add(new Student(7,"Bimlesh",250,"Barailly"));
		list1.add(new Student(8,"Sumit",350,"New Delhi"));
		list1.add(new Student(9,"Prajwal",550,"Lucknow"));
		list1.add(new Student(10,"Pradyum",900,"Allahbad"));
		
		List<Student> list2 = list1.stream().filter(s->{
			if(s.getName().length() % 2 == 0) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		
		List<Student> list3 = list2.stream().map(s->{
			return new Student(s.getRoll(),s.getName().toUpperCase(),s.getMarks(),s.getAddress());
		}).collect(Collectors.toList());
		
		Collections.sort(list3, (s1,s2)->(int)s2.getMarks()-(int)s1.getMarks());
		
		list1.forEach(s->System.out.println(s));
		System.out.println();
		list3.forEach(s->System.out.println(s));
	}

}
