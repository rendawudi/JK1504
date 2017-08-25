package com.js1504.exception;

public class Userexcption extends RuntimeException{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -8525025622965531101L;
		public Userexcption(String message)
	{
		super(message);
	}
	public Userexcption(String message,Throwable cause)
	{
		super(message,cause);
	}
}
