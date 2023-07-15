package com.masai.problem2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCenter {
	File file;
	String contentToWrite;
	String contentToAppend;
	public ReadWriteCenter(String file, String contentToWrite, String contentToAppend) {
		this.file = new File(file);
		this.contentToWrite = contentToWrite;
		this.contentToAppend = contentToAppend;
	}
	
	public void writeToFile() throws Exception {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(contentToWrite);
		bw.close();
		
	}
	
	public void appendToFile() throws Exception {
		
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(contentToAppend);
		bw.close();
		
	}
	public List<Integer> getAnalysis() throws Exception{
		
		List<Integer> list = new ArrayList<>();
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		char[] arr = br.readLine().toCharArray();
		int digit =0,letter =0,specialChar = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] >=48 && arr[i] <=57) digit++;
			else if((arr[i] >=65 && arr[i] <=90 ) || (arr[i] >=97 && arr[i] <=122))letter++;
			else specialChar++;
		}
		
		list.add(digit);
		list.add(letter);
		list.add(specialChar);
		
		return list;
	}
	
}
