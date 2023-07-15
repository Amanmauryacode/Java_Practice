package com.masai.problem3;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class deserialiezedProduct {
	static Map<String,Double> deserialiezed() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("spices.ser"));
		Map<String,Double> Product = (Map<String,Double>)ois.readObject();
		return Product;
	}
	
}
