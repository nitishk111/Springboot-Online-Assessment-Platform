package com.cg.login.exceptions;

@SuppressWarnings("serial")
public class DuplicateUserException extends RuntimeException{
	public DuplicateUserException(String message) {
		super(message);
	}
}
