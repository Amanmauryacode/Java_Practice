package com.masai.week3;

public class TooShortCourseException extends Exception {
	TooShortCourseException(){
		
	}
	TooShortCourseException(String msg){
		super(msg);
	}
}
