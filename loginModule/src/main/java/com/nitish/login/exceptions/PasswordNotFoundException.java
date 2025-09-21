package com.nitish.login.exceptions;
@SuppressWarnings("serial")
public class PasswordNotFoundException extends RuntimeException{
	public PasswordNotFoundException(String message) {
		super(message);
	}
}
