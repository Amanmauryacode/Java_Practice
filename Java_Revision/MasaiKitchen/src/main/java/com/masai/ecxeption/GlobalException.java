package com.masai.ecxeption;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> LoginExceptionHandler(LoginException le, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(le.getMessage(), req.getDescription(false), LocalDateTime.now());
		ResponseEntity<MyErrorDetails> rs = new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);
		return rs;
	}

	@ExceptionHandler(RecipeException.class)
	public ResponseEntity<MyErrorDetails> AuthorizationExceptionHandler(RecipeException re, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(re.getMessage(), req.getDescription(false), LocalDateTime.now());
		ResponseEntity<MyErrorDetails> rs = new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);
		return rs;
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> BookExceptionHandler(UserException ue, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now());
		ResponseEntity<MyErrorDetails> rs = new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
		return rs;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> GenericExceptionHandler(Exception ex, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(ex.getMessage(), req.getDescription(false), LocalDateTime.now());
		ResponseEntity<MyErrorDetails> rs = new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		return rs;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> NohandlerFoundExceptionHandler(NoHandlerFoundException nf, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(nf.getMessage(), req.getDescription(false), LocalDateTime.now());

		ResponseEntity<MyErrorDetails> rs = new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

		return rs;

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MANVExceptionHandler(MethodArgumentNotValidException mv) {

		MyErrorDetails err = new MyErrorDetails("Validation Error",
				mv.getBindingResult().getFieldError().getDefaultMessage(), LocalDateTime.now());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

}
