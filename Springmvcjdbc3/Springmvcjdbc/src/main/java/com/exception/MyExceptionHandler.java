package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

		
		@ExceptionHandler(value=NullPointerException.class)
		public ResponseEntity<Object> exception(NullPointerException exception){
			return new ResponseEntity<>("Exception occured",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

}
