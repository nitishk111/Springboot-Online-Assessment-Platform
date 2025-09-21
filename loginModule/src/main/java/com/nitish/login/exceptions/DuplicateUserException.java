package com.nitish.login.exceptions;

@SuppressWarnings("serial")
public class DuplicateUserException extends RuntimeException{
	public DuplicateUserException(String message) {
		super(message);
	}
}
