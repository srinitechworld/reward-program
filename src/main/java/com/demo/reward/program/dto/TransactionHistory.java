package com.demo.reward.program.dto;

import java.util.Date;

public class TransactionHistory {

	private String customerID;
	
	private String customerName;
	
	private double purchaseAmt;
	
	private Date purchaseDt;

	public TransactionHistory(String customerID, String customerName, double purchaseAmt, Date purchaseDt) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.purchaseAmt = purchaseAmt;
		this.purchaseDt = purchaseDt;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(double purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public Date getPurchaseDt() {
		return purchaseDt;
	}

	public void setPurchaseDt(Date purchaseDt) {
		this.purchaseDt = purchaseDt;
	}

	@Override
	public String toString() {
		return "TransactionHistory [customerID=" + customerID + ", customerName=" + customerName + ", purchaseAmt="
				+ purchaseAmt + ", purchaseDt=" + purchaseDt + "]";
	}
	
	
}
