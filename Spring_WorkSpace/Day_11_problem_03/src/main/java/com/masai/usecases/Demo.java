package com.masai.usecases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.model.Student;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext clx = new AnnotationConfigApplicationContext(AppConfig.class);
		Jdbc jd = clx.getBean("jdbc",Jdbc.class);
		jd.insertStudent(new Student(1,"Aman","Varanasi"));
	}
}
