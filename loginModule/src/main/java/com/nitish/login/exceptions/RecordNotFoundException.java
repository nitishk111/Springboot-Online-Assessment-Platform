package com.nitish.login.exceptions;
@SuppressWarnings("serial")
public class RecordNotFoundException extends RuntimeException{
	public RecordNotFoundException(String message) {
		super(message);
	}
}
