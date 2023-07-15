package com.masai.package1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class deserialiezed {

	public static Map<String,Double> serialiezed() throws Exception{
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("spices.ser"));
		Map<String,Double> products = (Map<String,Double>) ois.readObject();
		ois.close();
		return products;
	}
}
