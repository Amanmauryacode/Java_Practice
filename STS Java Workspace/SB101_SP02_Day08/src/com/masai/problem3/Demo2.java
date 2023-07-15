package com.masai.problem3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fio = new FileInputStream("studentdata.txt");
		ObjectInputStream ois = new ObjectInputStream(fio);
		
		List<Student> list= (List<Student>)ois.readObject();
		
		list.forEach(l->System.out.println(l));
	}

}
