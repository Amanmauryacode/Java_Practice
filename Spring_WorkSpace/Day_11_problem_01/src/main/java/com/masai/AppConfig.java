package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.masai"})
@PropertySource("p.properties")
public class AppConfig {

	@Bean
	public List<String> cities(){
		
		List<String> cities = new ArrayList<String>();
		
		ResourceBundle rs = ResourceBundle.getBundle("p");
		
		cities.add(rs.getString("city1"));
		cities.add(rs.getString("city2"));
		cities.add(rs.getString("city3"));
		cities.add(rs.getString("city4"));
		cities.add(rs.getString("city5"));
		return cities;
	}
	@Bean
	public List<Student> stdList(){
		
		List<Student> stdList = new ArrayList<>();
		
		stdList.add(new Student(1,"Aman","Varanasi"));
		stdList.add(new Student(2,"Rahul","Dehradun"));
		stdList.add(new Student(3,"Raunak","Jaipur"));
		stdList.add(new Student(4,"Anuj","Gorakhpur"));
		stdList.add(new Student(5,"Shubham","Pune"));
		
		return stdList;
		
	}
}
