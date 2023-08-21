package com.demo.reward.program.util;

import java.util.List;

import com.demo.reward.program.dto.TransactionHistory;

public class RequestValidator {

	public static boolean isValidTransactions(List<TransactionHistory> transactions) throws ValidatorException {
		if (transactions == null) {
			throw new ValidatorException("Transaction History List object is Null");
		} else if (transactions.size() == 0) {
			throw new ValidatorException("Transaction History List object is empty");
		}
		return true;
	}
	
	public static boolean isValidAmt(double purchaseAmt) throws ValidatorException {
		if(purchaseAmt <= 0) {
			throw new ValidatorException("Invalid Purchase Amount : " + purchaseAmt);
		}
		return true;
	}
}
