package com.masai.week3;

public class TooMuchMedicalLeavesException extends Exception {
	TooMuchMedicalLeavesException(){
		
	}
	TooMuchMedicalLeavesException(String msg){
		super(msg);
	}
}
