package com.masai.week3;

public class TooShortAttendanceException extends Exception {
	TooShortAttendanceException(){
		
	}
	TooShortAttendanceException(String msg){
		super(msg);
	}
}
