package com.masai.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyErrorDetails {

	private String message;
	private String details;
	private LocalDateTime timestamp;
	public MyErrorDetails(String message, String details, LocalDateTime timestamp) {
		
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}
	
	
}
