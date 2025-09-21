package com.nitish.users.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nitish.users.controller.ResponseInfo;


/**
 * 
 *GlobalExceptions Class 
 *
 */
@RestControllerAdvice
public class GlobalExceptions {
	@ExceptionHandler(Exception.class)
	ResponseEntity<ResponseInfo> exceptionHandler(Exception ie,HttpServletRequest req){
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),ie.getMessage(),req.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo,HttpStatus.NOT_FOUND);
		
		
	}
	

}
