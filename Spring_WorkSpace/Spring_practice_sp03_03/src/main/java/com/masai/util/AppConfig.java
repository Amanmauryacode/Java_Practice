package com.masai.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.masai.model.Book;
import com.masai.model.Librarian;
import com.masai.model.Member;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class AppConfig {

	@Bean
	public Map<Librarian, List<Book>> bookMap(){
		
		Map<Librarian, List<Book>> map = new HashMap<>();
		
		Librarian lib1 = new Librarian(1, "Aman", 21, 4, "aman@gmail.com", "8419037940");
		Librarian lib2 = new Librarian(2, "Anuj", 25, 2, "anuj@gmail.com", "7800596122");
		Librarian lib3 = new Librarian(3, "Rounak", 53, 1, "rounak@gmail.com", "123456789");
		
		
		List<Book> bookList1 = new ArrayList<>();
		List<Book> bookList2 = new ArrayList<>();
		List<Book> bookList3 = new ArrayList<>();
		
		bookList1.add(new Book(1, "Rich Dad Poor Dad", "xyz", 1999, true));
		bookList1.add(new Book(2, "abc", "xyz", 2010, true));
		bookList1.add(new Book(3, "cde", "efg", 2000, true));
		
		bookList2.add(new Book(1, "aaa", "bbb", 1990, true));
		bookList2.add(new Book(2, "ccc", "ddd", 2000, true));
		bookList2.add(new Book(3, "eee", "fff", 2002, true));
		
		bookList3.add(new Book(1, "ggg", "hhh", 1885, true));
		bookList3.add(new Book(2, "iii", "jjj", 2005, true));
		bookList3.add(new Book(3, "kkk", "lll", 2000, true));
		
		map.put(lib1, bookList1);
		map.put(lib2, bookList2);
		map.put(lib3, bookList3);
		
		return map;
	}
	
	@Bean
	public List<Librarian> librarianList(){
		
		List<Librarian> list = new ArrayList<>();
		list.add(new Librarian(1, "Aman", 21, 4, "aman@gmail.com", "8419037940"));
		list.add(new Librarian(2, "Anuj", 25, 2, "anuj@gmail.com", "7800596122"));
		list.add(new Librarian(3, "Rounak", 53, 1, "rounak@gmail.com", "123456789"));
		
		
		return list;
		
	}
	
	@Bean
	public List<Member> memberList(){
		List<Member> list = new ArrayList<>();
		
		list.add(new Member(1, "Rahul", 26, 2, "rahul@gamil.com", "1245789632"));
		list.add(new Member(2, "Gandhi", 16, 4, "gandhi@gamil.com", "7525154589"));
		list.add(new Member(3, "Golu", 21, 3, "golu@gamil.com", "9580538395"));
		
		
		return list;
	}
}
