package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class AppConfig {

	@Bean
	public List<Product> products() {
		List<Product> list = new ArrayList<>();

		list.add(new Fruits("Apple", 12, 5));
		list.add(new Fruits("Orange", 4, 6));
		list.add(new Vegetables("Patato", 2, 10));
		list.add(new Vegetables("Tomato", 4, 12));
		list.add(new Bakery("PenCake", 50, 5));
		list.add(new Bakery("VanilaCake", 250, 1));
		return list;
	}

}
