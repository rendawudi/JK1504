package com.jk1504.exception;

public class taskxgexception extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 444774145759405143L;
	public taskxgexception(String message)
	{
		super(message);
	}
	public taskxgexception(String message,Throwable cause)
	{
		super(message,cause);
	}
}
