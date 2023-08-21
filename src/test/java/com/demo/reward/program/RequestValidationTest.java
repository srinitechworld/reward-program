package com.demo.reward.program;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.demo.reward.program.service.RewardProgramService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RequestValidationTest.class)
public class RequestValidationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RewardProgramService service;

	@Test
	public void testCalRewardPointInvalidZeroAmt() throws Exception {
		mockMvc.perform(get("/calRewardPoint/purchaseAmt/0")).andExpect(status().isNotFound());
	}
	
	@Test
	public void testCalRewardPointInvalidNegativeAmt() throws Exception {
		mockMvc.perform(get("/calRewardPoint/purchaseAmt/-100")).andExpect(status().isNotFound());
	}
	
	@Test
	public void testCalRewardPointValidAmt() throws Exception {
		mockMvc.perform(get("calRewardPoint/purchaseAmt/120")).andDo(print()).andExpect(status().isOk());		
	}
}
