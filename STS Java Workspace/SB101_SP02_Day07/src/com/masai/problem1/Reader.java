package com.masai.problem1;

import java.io.*;

public class Reader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("abc.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String num = br.readLine();
		
		FileWriter fw = new FileWriter("Filter.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		System.out.println("All Mobile Numbers....");
		while(num != null) {
			
			if((num.charAt(0) == '9' ||num.charAt(0) == '8' ||num.charAt(0) == '7' ||num.charAt(0) == '6') && num.length() == 10 ) {
				bw.write(num);
				bw.newLine();
//				System.out.println(num);
			}
			System.out.println(num);
			num = br.readLine();
		}
		br.close();
		bw.close();
		System.out.println();
		FileReader fr1 = new FileReader("Filter.txt");
		BufferedReader br1 = new BufferedReader(fr1);
		
		System.out.println("Filtered Mobile Numbers");
		br1.lines().forEach(System.out::println);
		
		System.out.println("Done...");
	}

}
