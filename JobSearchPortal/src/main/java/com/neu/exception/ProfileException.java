package com.neu.exception;

public class ProfileException extends Exception {

	public ProfileException(String message)
	{
		super("ProfileException-"+message);
	}
	
	public ProfileException(String message, Throwable cause)
	{
		super("ProfileException-"+message,cause);
	}
}
