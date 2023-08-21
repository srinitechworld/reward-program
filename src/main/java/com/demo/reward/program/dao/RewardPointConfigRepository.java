package com.demo.reward.program.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.reward.program.entity.RewardPointConfig;

public interface RewardPointConfigRepository extends JpaRepository<RewardPointConfig, Integer> {
	
	public List<RewardPointConfig> findByActiveInd(boolean activeInd);

}
