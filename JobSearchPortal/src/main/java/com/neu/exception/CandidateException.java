package com.neu.exception;

public class CandidateException extends Exception {
	
	public CandidateException(String message)
	{
		super("CandidateException-"+message);
	}
	
	public CandidateException(String message, Throwable cause)
	{
		super("CandidateException-"+message,cause);
	}

}
