package com;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.enrollment.model.DataNotFoundException;
import com.enrollment.model.ExceptionResponse;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(DataNotFoundException exception, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("Not found");
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
}