package com.masai.problem2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Demo {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("car.txt");
	    if(!Files.exists(path)) {
	      Files.createFile(path);
	    }
	    
	    byte[] bytes = "Ertiga 7 1200000 Toyota\r\nEon 5 475000 Hyundai\r\nCreta 5 1450000 Hyundai\r\nAlto 5 499000 Maruti\r\nFortuner 7 3450000 Toyota".getBytes();
	    
	    Files.write(path, bytes);
	    
	    List<String> content = Files.readAllLines(path);
	    
	    int totalCost = content.stream().map(s->Integer.parseInt(s.split(" ")[1])*Integer.parseInt(s.split(" ")[2])).reduce(0,(a1,a2)->a1+a2);
	    
	    System.out.println("Total Cost of Cars : "+totalCost);
	    
	    content.stream().filter(s-> s.contains("Hyundai")).forEach(s->System.out.println(s));
	}
}
