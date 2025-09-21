package com.nitish.login.exceptions;
@SuppressWarnings("serial")
public class UserNameNotFoundException extends RuntimeException{
	public UserNameNotFoundException(String message) {
		super(message);
	}
}
