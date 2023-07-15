package com.masai.package1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class serialization {

	public static void serialized() throws FileNotFoundException, IOException {
		Map<String,Double> products = new LinkedHashMap<>();
		
		products.put("salt",30.00);
		products.put("turmeric",35.00);
		products.put("cumin",40.00);
		products.put("cinnamon",70.00);
		products.put("mace",25.00);
		
		ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream("spices.ser"));
		oos.writeObject(products);
		oos.close();
		
	}
}
