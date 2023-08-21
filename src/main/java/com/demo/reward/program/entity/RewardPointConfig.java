package com.demo.reward.program.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RewardPointConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int configID;
	
	private double spentAmtRange;
	
	private int rewardPoint;
	
	private boolean activeInd;
	
	

	public RewardPointConfig() {
		super();
	}
	
	

	public RewardPointConfig(int configID, double spentAmtRange, int rewardPoint, boolean activeInd) {
		super();
		this.configID = configID;
		this.spentAmtRange = spentAmtRange;
		this.rewardPoint = rewardPoint;
		this.activeInd = activeInd;
	}



	public int getConfigID() {
		return configID;
	}

	public void setConfigID(int configID) {
		this.configID = configID;
	}

	public double getSpentAmtRange() {
		return spentAmtRange;
	}

	public void setSpentAmtRange(double spentAmtRange) {
		this.spentAmtRange = spentAmtRange;
	}

	public int getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(int rewardPoint) {
		this.rewardPoint = rewardPoint;
	}

	public boolean isActiveInd() {
		return activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}
	
	
	
}
