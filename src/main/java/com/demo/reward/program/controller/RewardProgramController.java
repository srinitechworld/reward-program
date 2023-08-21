package com.demo.reward.program.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.reward.program.dto.TransactionHistory;
import com.demo.reward.program.entity.RewardPointConfig;
import com.demo.reward.program.service.RewardProgramService;
import com.demo.reward.program.util.ValidatorException;

import static com.demo.reward.program.util.RequestValidator.*;

@RestController
public class RewardProgramController {

	private Logger logger = LoggerFactory.getLogger(RewardProgramController.class);

	@Autowired
	private RewardProgramService service;

	@GetMapping("/calRewardPoint/purchaseAmt/{purchaseAmt}")
	public ResponseEntity<Integer> calRewardPoint(@PathVariable double purchaseAmt) {
		logger.info("Inside getReward method");
		int rewardPoint = 0;
		try {
			if(isValidAmt(purchaseAmt)) {
				rewardPoint = service.calRewardPoint(purchaseAmt);
			}
		} catch (ValidatorException exception) {
			logger.error("Invalid Request : " + exception.getMessage(),
					exception);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Request : " + exception.getMessage(),
					exception);
		}
		logger.info("End getReward method");
		return new ResponseEntity<Integer>(rewardPoint, HttpStatus.OK);
	}

	@GetMapping("/getRewardConfig")
	public ResponseEntity<List<RewardPointConfig>> getRewardConfig() {
		logger.info("Inside getRewardProg method");
		List<RewardPointConfig> config = service.fetchRewardConfig();
		if (config == null || config.size() == 0) {
			return new ResponseEntity<>(config, HttpStatus.NO_CONTENT);
		}
		logger.info("End getRewardProg method");
		return new ResponseEntity<>(config, HttpStatus.OK);
	}

	@PostMapping("/calRewardPointByMonth")
	public ResponseEntity<Map<String, Map<String, Integer>>> calRewardByMonth(
			@RequestBody List<TransactionHistory> transactionList) throws ResponseStatusException {
		logger.info("Inside calRewardByMonth method");
		Map<String, Map<String, Integer>> pointByMonth = new LinkedHashMap<>();
		try {
			if (isValidTransactions(transactionList)) {
				pointByMonth = service.calRewardByMonth(transactionList);
			}
		} catch (ValidatorException exception) {
			logger.error("Invalid Request : " + exception.getMessage(),
					exception);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Request : " + exception.getMessage(),
					exception);
		}
		logger.info("Inside calRewardByMonth method");
		return new ResponseEntity<>(pointByMonth, HttpStatus.OK);
	}

}
