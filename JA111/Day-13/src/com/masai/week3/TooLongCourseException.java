package com.masai.week3;

public class TooLongCourseException extends Exception {
	TooLongCourseException(){
		
	}
	TooLongCourseException(String msg){
		super(msg);
	}
}
