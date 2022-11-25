package uk.co.wowcher.service;

public interface ClockService {

	 boolean validation(String time);
	 
	 String checkHours(int timeHours); 
	 String checkMinutes(int timeMinutes) ;
	 
	 public String convertTimeToWords(String time);
}
