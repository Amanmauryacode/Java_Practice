package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyDetailError> employeeException(CustomerException ee,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),ee.getMessage(),wr.getDescription(false));

		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyDetailError> projectException(BookingException pe,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),pe.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyDetailError> roleException(HotelException re,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),re.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyDetailError> exception(Exception e,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),e.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyDetailError> myNotFoundHandler(NoHandlerFoundException nhe, WebRequest wr) {

		MyDetailError med = new MyDetailError(LocalDateTime.now(), nhe.getMessage(), wr.getDescription(false));

		return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST);
	}
	
}
