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
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyDetailError> employeeException(EmployeeException ee,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),ee.getMessage(),wr.getDescription(false));

		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ProjectException.class)
	public ResponseEntity<MyDetailError> projectException(ProjectException pe,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),pe.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RoleException.class)
	public ResponseEntity<MyDetailError> roleException(RoleException re,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),re.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<>(mr,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<MyDetailError> departmentException(DepartmentException de,WebRequest wr){
		
		MyDetailError mr = new MyDetailError(LocalDateTime.now(),de.getMessage(),wr.getDescription(false));
		
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
