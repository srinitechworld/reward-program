package com.demo.reward.program.util;

public class ValidatorException extends Exception {

	public ValidatorException (String message, Throwable th) {
		super(message, th);
	}
	
	public ValidatorException (String message) {
		super(message);
	}
	
	public ValidatorException (Exception e) {
		super(e);
	}
}
