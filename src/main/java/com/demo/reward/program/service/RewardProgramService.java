package com.demo.reward.program.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.reward.program.dao.RewardPointConfigRepository;
import com.demo.reward.program.dto.TransactionHistory;
import com.demo.reward.program.entity.RewardPointConfig;
import com.demo.reward.program.util.RewardProgException;

import static com.demo.reward.program.util.RewardProgUtil.*;

@Service
public class RewardProgramService {

	private Logger logger = LoggerFactory.getLogger(RewardProgramService.class);

	@Autowired
	private RewardPointConfigRepository repository;

	public int calRewardPoint(double purchaseAmt) {
		logger.info("Inside calRewardPoint method");
		int rewardPoint = 0;

		List<RewardPointConfig> configList = fetchRewardConfig();
		for (RewardPointConfig config : configList) {
			rewardPoint += (purchaseAmt - config.getSpentAmtRange()) * config.getRewardPoint();
		}

		logger.info("End calRewardPoint method");
		return rewardPoint;
	}

	public List<RewardPointConfig> fetchRewardConfig() {
		logger.info("Inside fetchRewardProg method");
		List<RewardPointConfig> config = repository.findByActiveInd(true);
		logger.info("End fetchRewardProg method");
		return config;
	}

	public Map<String, Map<String, Integer>> calRewardByMonth(List<TransactionHistory> transList) {
		Map<String, Map<String, Integer>> pointByMonth = new LinkedHashMap<>();
		for (TransactionHistory trans : transList) {
			try {
				int rewardPoint = calRewardPoint(trans.getPurchaseAmt());
				int month = getMonth(trans.getPurchaseDt());
				
				pointByMonth.putIfAbsent(trans.getCustomerID(), new LinkedHashMap<>());
				pointByMonth.get(trans.getCustomerID()).merge(String.valueOf(month), rewardPoint, Integer :: sum);

			} catch (RewardProgException exception) {
				logger.error("Error occured while processing the transaction: " + trans.toString()
						+ " Exception Message: " + exception.getMessage(), exception);
				// Update the error details in database
			}
		}
		return pointByMonth;
	}
}
