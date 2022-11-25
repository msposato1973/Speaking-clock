package uk.co.wowcher.service.impl;

import java.util.HashMap;
import java.util.Map;

import uk.co.wowcher.msg.TemplateMessege;
import uk.co.wowcher.service.ClockService;
import uk.co.wowcher.utility.UtilityMapTime;

/***
 * 
 * @author massimo.sposato
 *
 */
public class ClockServiceImpl implements ClockService {
	
	private int hours;
    private int minutes;
	
	/**
     * Initializes a newly created {@code ClockServiceImpl} object so that initializes
     * the hours, minutes and result.
     *
     * @param  hour the initial string hour entered.
     */
    public ClockServiceImpl() {}
    
	@Override
	public boolean validation(String sTime) {
		boolean validationStatus = false;
		String[] hours = null;
		
		try {
			 hours = sTime.trim().split(":");
        } catch (NumberFormatException e) {
            throw new NumberFormatException(TemplateMessege.INVALIDHOURFORMAT);
        }
	
        try {
       
        	this.hours =   Integer.parseInt(hours[0]);
        	this.minutes = Integer.parseInt(hours[1]);
        	 
        	validationStatus = true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(TemplateMessege.INVALIDHOURFORMAT);
        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException(TemplateMessege.INVALIMINUTFORMAT);
        }
        
		 return validationStatus;
	}

	
	public String checkHours(int timeHours) {
		return (timeHours == 24 || timeHours == 12) ? UtilityMapTime.hoursDay.get(timeHours) : checkOther(timeHours);
	}

	private String checkOther(int timeHours) {
		
		if(timeHours<10) {
			return UtilityMapTime.oneToNine.get(timeHours);
		} else if (timeHours > 9 && timeHours < 20) {
			return UtilityMapTime.tenToNineteen.get(timeHours);
		} else {
			return UtilityMapTime.twentyToYwentytree.get(timeHours);
		} 
	
	}
	
	public String checkMinutes(int timeMinutes) {
		
		String resultsTime = "";
		
		if (timeMinutes == 0) {
			  return resultsTime;
		} else if(timeMinutes<10){
			resultsTime = UtilityMapTime.oneToNine.get(timeMinutes);
		} else if (timeMinutes > 9 && timeMinutes < 20) {
			resultsTime = UtilityMapTime.tenToNineteen.get(timeMinutes) + " " ;
		} else if (timeMinutes > 20 && timeMinutes < 30) {
			resultsTime = UtilityMapTime.tensToFifty.get(20) + " " +  UtilityMapTime.oneToNine.get(timeMinutes - 20);
		} else if (timeMinutes > 30 && timeMinutes < 40) {
			resultsTime = UtilityMapTime.tensToFifty.get(30) + " " + UtilityMapTime.oneToNine.get(timeMinutes - 30);
		} else if (timeMinutes > 40 && timeMinutes < 50) {
			resultsTime = UtilityMapTime.tensToFifty.get(40) + " " + UtilityMapTime.oneToNine.get(timeMinutes - 40);
		} else {
			resultsTime = UtilityMapTime.tensToFifty.get(50) + " " + UtilityMapTime.oneToNine.get(timeMinutes - 50);
		} 
		

		
	   return " " + resultsTime;
	}
	
	@Override
	public String convertTimeToWords(String sTime) {
		StringBuilder result = new StringBuilder("It's ");
		
		if(validation(sTime)) {
			result.append(checkHours(this.hours));
			result.append(checkMinutes(this.minutes));
		};
		
		return result.toString();
	}
 

}
