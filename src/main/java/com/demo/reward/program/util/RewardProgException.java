package com.demo.reward.program.util;

public class RewardProgException extends Exception {

	public RewardProgException (String message, Throwable th) {
		super(message, th);
	}
	
	public RewardProgException (String message) {
		super(message);
	}
	
	public RewardProgException (Exception e) {
		super(e);
	}
}
