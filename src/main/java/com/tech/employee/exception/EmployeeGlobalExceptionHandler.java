package com.tech.employee.exception;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {
	@ExceptionHandler(EmptyException.class)
	public ResponseEntity<Object> nameNotFound(EmptyException n) {
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> salaryNotFound(SalaryNotFoundException n) {
		return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	

}
