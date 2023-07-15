package com.masai.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyDetailError {
	
	
	private LocalDateTime timeStamp;
	private String message;
	private String details;

	public MyDetailError(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public MyDetailError() {
		super();
		// TODO Auto-generated constructor stub
	}

}
