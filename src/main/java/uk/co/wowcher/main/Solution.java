package uk.co.wowcher.main;

import uk.co.wowcher.service.ClockService;
import uk.co.wowcher.service.impl.ClockServiceImpl;

public class Solution {

	public static void main(String[] args) {
		ClockService clockService = new ClockServiceImpl();
		String result = clockService.convertTimeToWords("08:34");
		
		System.out.println(result);
	}

}
