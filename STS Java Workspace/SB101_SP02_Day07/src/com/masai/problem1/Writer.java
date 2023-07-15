package com.masai.problem1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("abc.txt");
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("8419037940");
		bw.newLine();
		bw.write("6306804122");
		bw.newLine();
		bw.write("9936206632");
		bw.newLine();
		bw.write("6524578945");
		bw.newLine();
		bw.write("12458469455");
		bw.newLine();
		bw.write("997845125465");
		bw.newLine();
		bw.write("12458756");
		bw.newLine();
		bw.write("99457261");
		bw.newLine();
		bw.write("78451289642");
		bw.newLine();
		bw.write("33458246578");
		bw.newLine();
		
		bw.flush();
		bw.close();
		System.out.println("Done...");
	}
	
}
