package com.masai.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyDetailError {

	private LocalDateTime timeStrap;
	private String message;
	private String details;
	public LocalDateTime getTimeStrap() {
		return timeStrap;
	}
	public void setTimeStrap(LocalDateTime timeStrap) {
		this.timeStrap = timeStrap;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public MyDetailError(LocalDateTime timeStrap, String message, String details) {
		super();
		this.timeStrap = timeStrap;
		this.message = message;
		this.details = details;
	}
	public MyDetailError() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyDetailError [timeStrap=" + timeStrap + ", message=" + message + ", details=" + details + "]";
	}
	
	
	
}
