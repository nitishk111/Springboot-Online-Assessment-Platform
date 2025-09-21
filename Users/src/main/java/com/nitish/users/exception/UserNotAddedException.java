package com.nitish.users.exception;

/**
 * 
 * UserNotAddedException Class
 *
 */
@SuppressWarnings("serial")
public class UserNotAddedException extends RuntimeException {
	public UserNotAddedException(String message) {
		super(message);
	}

}
