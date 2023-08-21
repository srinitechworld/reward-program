package com.demo.reward.program.util;

import java.util.Calendar;
import java.util.Date;

public class RewardProgUtil {

	public static int getMonth(Date date) throws RewardProgException {
		int month = 0;
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			month = cal.get(Calendar.MONTH);
		} else {
			throw new RewardProgException("Date object is Null");
		}
		return month;
	}
}
