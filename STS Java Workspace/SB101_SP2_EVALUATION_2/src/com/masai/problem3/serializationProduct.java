package com.masai.problem3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class serializationProduct {
	
	static void sserialiezed(Map<String,Double> product) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("spices.ser"));
		oos.writeObject(product);
		oos.close();
		
	}
}
