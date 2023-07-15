package com.masai.day2;

import java.util.ArrayList;
import java.util.List;





interface Demo1{
	public void printDetail(Students student);
}

class referenceFun{
	public static void fun(Students s) {
		System.out.println(s);
	}
	
	public void fun1(Students s) {
		System.out.println(s);
	}
	
	referenceFun(Students s){
		System.out.println(s);
	}
	referenceFun(){
		
	}
}

public class Problem2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Students> list = new ArrayList<>();
		list.add(new Students(1,"Aman","amanmaurya@gmail.com",450,"India"));
		list.add(new Students(2,"Anshu","anshu@gmail.com",350,"Pakistan"));
		list.add(new Students(3,"Shubham","shubham@gmail.com",250,"Amrica"));
		list.add(new Students(4,"Pankaj","pankaj@gmail.com",550,"Africa"));
		list.add(new Students(5,"Nagesh","nagesh@gmail.com",650,"Austrila"));
		
		Demo1 s1 = referenceFun::fun;
		Demo1 s2 = new referenceFun()::fun1;
		Demo1 s3 = referenceFun::new;
		
		list.forEach(stud-> s1.printDetail(stud));
		System.out.println("=-=-=-=--=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=");
		list.forEach(stud-> s2.printDetail(stud));
		System.out.println("=-=-=-=--=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=");
		list.forEach(stud-> s3.printDetail(stud));
		
	}

}