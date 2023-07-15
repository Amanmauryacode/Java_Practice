
package com.masai.day2;
import java.util.*;
import java.util.function.Predicate;

interface Intr {	
	public List<Students> findStudent(List<Students> stu);
}

class Aman{
	public List<Students> removeif(List<Students> st){
		List<Students> list = new ArrayList<>();
		st.forEach(s-> {
			if(s.getMarks()<500) {
				list.add(s);
			}
		});
		return list;
	}
}

public class Problem4 {
	
	
	
	public static void main(String[] args) {
		
		List<Students> list = new ArrayList<>();
		list.add(new Students(1,"Aman","amanmaurya@gmail.com",450,"India"));
		list.add(new Students(2,"Anshu","anshu@gmail.com",350,"Pakistan"));
		list.add(new Students(3,"Shubham","shubham@gmail.com",250,"Amrica"));
		list.add(new Students(4,"Pankaj","pankaj@gmail.com",550,"Africa"));
		list.add(new Students(5,"Nagesh","nagesh@gmail.com",650,"Austrila"));
		
		Intr i = new Aman()::removeif;
		i.findStudent(list).forEach(ch -> System.out.println(ch));
	}
}
