package com.masai.usecases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.service.LibraryService;
import com.masai.util.AppConfig;

public class Main {

	public static void main(String[] args) {
		ApplicationContext clx = new AnnotationConfigApplicationContext(AppConfig.class);

		LibraryService ls = clx.getBean(LibraryService.class);
		System.out.println("----------------------------------------------");
		ls.printBookMap();
		System.out.println("----------------------------------------------");
		ls.printLibrarianList();
		System.out.println("----------------------------------------------");
		ls.printMemberList();
		System.out.println("----------------------------------------------");
		ls.issueBook(1, 2, 1);
		System.out.println("----------------------------------------------");
		ls.returnBook(1, 2, 1);
		System.out.println("----------------------------------------------");
		
		((AnnotationConfigApplicationContext)clx).close();
	}
}
