package com.javatechie.jwt.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javatechie.jwt.api.excetion.ErrorResponse;
import com.javatechie.jwt.api.excetion.ServiceException;

@ControllerAdvice
public class ExceptionAdvise {

	@ExceptionHandler(ServiceException.class)
public ResponseEntity<ErrorResponse> handleException(ServiceException ex)
{
		ErrorResponse error=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	
}
}
