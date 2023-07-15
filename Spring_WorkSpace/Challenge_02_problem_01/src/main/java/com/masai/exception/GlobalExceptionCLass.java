package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionCLass {
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> productException(ProductException pe, WebRequest wr) {
		
		MyErrorDetails mr = new MyErrorDetails(LocalDateTime.now(),pe.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exception(Exception e, WebRequest wr) {
		MyErrorDetails med = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);

	}

	// to handle wrong uri
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myNotFoundHandler(NoHandlerFoundException nhe, WebRequest wr) {

		MyErrorDetails med = new MyErrorDetails(LocalDateTime.now(), nhe.getMessage(), wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
}
